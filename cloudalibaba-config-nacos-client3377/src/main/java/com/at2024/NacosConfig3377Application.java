package com.at2024;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyh
 * @date 2024-08-06 22:25:53
 */
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class NacosConfig3377Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(NacosConfig3377Application.class, args);
            log.info("****************************************NacosConfig3377启动成功****************************************");
        } catch (Exception e) {
            log.error("NacosConfig3377启动失败",e);
        }
    }
}