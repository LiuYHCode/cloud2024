package com.at2024.cloud.controller;

import com.at2024.cloud.entities.Order;
import com.at2024.cloud.order.OrderService;
import com.at2024.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyh
 * @date 2024-08-11 18:25:57
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 创建订单AT
     * 测试地址：http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
     */
    @GetMapping("/order/create")
    public ResultData create(Order order) {
        orderService.create(order);
        return ResultData.success(order);
    }
}
