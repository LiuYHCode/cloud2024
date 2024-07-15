package com.at2024.controller;

import com.at2024.entities.PayDTO;
import com.at2024.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lyh
 * @date 2024-07-15 23:26:06
 */
@RestController
public class OrderController {
    public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码

    @Resource
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        //三个参数就是url，请求参数，返回对象
        //postman测试 http://localhost:80/consumer/pay/add?payNo=paystring&orderNo=abc&userId=4&amount=9.99
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add",payDTO,ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id,ResultData.class,id);
    }

    @GetMapping("/consumer/pay/update")
    public ResultData updateOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/update",payDTO,ResultData.class);
    }

    @GetMapping("/consumer/pay/delete/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/delete/" + id,ResultData.class,id);
    }
}
