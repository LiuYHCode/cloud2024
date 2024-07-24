package com.at2024.cloud.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.at2024.cloud.api.PayFeignApi;
import com.at2024.cloud.entities.PayDTO;
import com.at2024.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lyh
 * @date 2024-07-15 23:26:06
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO) {
        log.info("第一步，模拟本地addOrder新增订单成功(省略sql操作)，第二步，再开启addPay远程支付微服务调用");
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPay(@PathVariable("id") Integer id) {
        log.info("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = null;
        try {
            log.info("调用开始" + DateUtil.now());
            resultData = payFeignApi.getPay(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("调用结束" + DateUtil.now());
        }
        return resultData;
    }

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return
     */
    @GetMapping(value = "/feign/pay/mylb")
    public String mylb() {
        return payFeignApi.mylb();
    }
}
