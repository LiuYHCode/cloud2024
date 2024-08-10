package com.at2024;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lyh
 * @date 2024-08-05 23:42:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class ConsumerNacosApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ConsumerNacosApplication.class, args);
            log.info("****************************************Consumer83启动成功****************************************");
        } catch (Exception e) {
            log.error("Consumer83启动失败",e);
        }
    }
}