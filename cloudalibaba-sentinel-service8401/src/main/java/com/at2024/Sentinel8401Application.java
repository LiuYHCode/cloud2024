package com.at2024;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyh
 * @date 2024-08-07 21:09:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class Sentinel8401Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Sentinel8401Application.class, args);
            log.info("****************************************sentinel8401启动成功****************************************");
        } catch (Exception e) {
            log.error("sentinel8401启动失败",e);
        }
    }
}