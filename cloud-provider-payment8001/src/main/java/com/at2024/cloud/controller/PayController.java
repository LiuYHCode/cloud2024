package com.at2024.cloud.controller;

import com.at2024.cloud.entities.Pay;
import com.at2024.cloud.entities.PayDTO;
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
    public String addPay(@RequestBody Pay pay) {
        log.info(pay.toString());
        int i = payService.insert(pay);
        return "成功插入记录，返回值" + i;
    }

    @PostMapping("/pay/delete/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }

    /**
     * payDTO是前端工程师隐藏部分信息展示到前端的数据
     * @param payDTO
     * @return
     */
    @PostMapping("/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public String updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        log.info(payDTO.toString());
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return "成功修改记录值，返回值" + i;
    }

    /**
     * 返回给前端依旧是Pay数据，前端自行展示为PayDTO数据
     * @param id
     * @return
     */
    @PostMapping("/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public Pay getPay(@PathVariable("id") Integer id) {
        log.info("查询记录id编号:" + id);
        return payService.getById(id);
    }

    @PostMapping("/pay/getAll")
    @Operation(summary = "查询支付的所有信息",description = "查询支付的所有信息方法")
    public List<Pay> getPayAll() {
        return payService.getAll();
    }
}
