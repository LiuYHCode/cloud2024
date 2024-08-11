package com.at2024.cloud.order.impl;

import com.at2024.cloud.api.AccountFeignApi;
import com.at2024.cloud.api.StorageFeignApi;
import com.at2024.cloud.entities.Order;
import com.at2024.cloud.mapper.OrderMapper;
import com.at2024.cloud.order.OrderService;
import io.seata.core.context.RootContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author lyh
 * @date 2024-08-11 18:17:44
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageFeignApi storageFeignApi;
    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    public void create(Order order) {
        //全局事务id的检查
        String xid = RootContext.getXID();
        log.info("-----------开始新建订单了: "+"\t"+"xid: "+xid);
        //订单新建时默认的状态是零，创建中
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);
        //插入订单成功以后即可获得插入mysql后的实体对象
        Order orderFromDB = null;
        //插入订单成功
        if (result > 0) {
            //从mysql里边查询出来刚插入的记录
            orderFromDB =  orderMapper.selectOne(order);
            log.info("--------->新建订单成功，oderFromDB info: "+orderFromDB.toString());
            System.out.println();
            //扣减库存
            log.info("-------> 订单微服务开始调用Storage库存，做扣减count");
            storageFeignApi.decrease(orderFromDB.getProductId(),orderFromDB.getCount());
            log.info("-------> 订单微服务结束调用Storage库存，做扣减完成");
            System.out.println();
            //扣减账户余额
            log.info("-------> 订单微服务开始调用Account账号，做扣减money");
            accountFeignApi.decrease(orderFromDB.getUserId(), orderFromDB.getMoney());
            log.info("-------> 订单微服务结束调用Account账号，做扣减完成");
            log.info("");
            //修改原始订单状态
            //订单状态status：0：创建中；1：已完结
            log.info("-------> 修改订单状态");
            orderFromDB.setStatus(1);
            //Tkmapper条件
            Example whereCondition=new Example(Order.class);
            Example.Criteria criteria=whereCondition.createCriteria();
            criteria.andEqualTo("userId",orderFromDB.getUserId());
            criteria.andEqualTo("status",0);
            int updateResult = orderMapper.updateByExampleSelective(orderFromDB, whereCondition);
            log.info("-------> 修改订单状态完成"+"\t"+updateResult);
            log.info("-------> orderFromDB info: "+orderFromDB);
        }
        log.info("");
        log.info("-----------结束新建订单了: "+"\t"+"xid: "+xid);
    }
}
