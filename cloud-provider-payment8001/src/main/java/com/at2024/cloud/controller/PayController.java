package com.at2024.cloud.controller;

import com.at2024.cloud.entities.Pay;
import com.at2024.cloud.entities.PayDTO;
import com.at2024.cloud.resp.ResultData;
import com.at2024.cloud.resp.ReturnCodeEnum;
import com.at2024.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lyh
 * @date 2024-07-14 18:25:05
 */
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
@Slf4j
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        log.info(pay.toString());
        int i = payService.insert(pay);
        return ResultData.success("成功插入记录，返回值" + i);
    }

    @PostMapping("/pay/delete/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    /**
     * payDTO是前端工程师隐藏部分信息展示到前端的数据
     * @param payDTO
     * @return
     */
    @PostMapping("/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        log.info(payDTO.toString());
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录值，返回值" + i);
    }

    /**
     * 返回给前端依旧是Pay数据，前端自行展示为PayDTO数据
     * @param id
     * @return
     */
    @PostMapping("/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getPay(@PathVariable("id") Integer id) {
        log.info("查询记录id编号:" + id);
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @PostMapping("/pay/getAll")
    @Operation(summary = "查询支付的所有信息",description = "查询支付的所有信息方法")
    public ResultData<List<Pay>> getPayAll() {
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }

    @PostMapping("/pay/error")
    @Operation(summary = "单独异常处理",description = "使用try catch处理异常而不是使用全局异常")
    public ResultData<Integer> payError() {
        Integer integer = Integer.valueOf(200);

        try {
            log.info("come in payError test");
            int i = 1 / 0;
        } catch (Exception e) {
            log.info("异常处理测试{}", e.getMessage());
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), ReturnCodeEnum.RC500.getMessage());
        }

        return ResultData.success(integer);
    }
}
