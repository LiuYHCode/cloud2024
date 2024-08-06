package com.at2024;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyh
 * @date 2024-08-05 23:25:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AlibabaPayment9001Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(AlibabaPayment9001Application.class, args);
            log.info("****************************************cloud9001启动成功****************************************");
        } catch (Exception e) {
            log.error("cloud9001启动失败",e);
        }
    }
}