package com.at2024.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.at2024.cloud.entities.Pay;
import com.at2024.cloud.resp.ResultData;
import com.at2024.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyh
 * @date 2024-08-04 11:30:30
 */
@RestController
public class PayGateWayController {
    @Resource
    private PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return ResultData.success("gateway info test："+ IdUtil.simpleUUID());
    }

}
