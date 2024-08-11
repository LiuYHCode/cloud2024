package com.at2024;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lyh
 * @date 2024-08-11 18:35:28
 */
@SpringBootApplication
@MapperScan("com.at2024.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //服务注册和发现
@EnableFeignClients
@Slf4j
public class SeataAccount2003Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SeataAccount2003Application.class, args);
            log.info("****************************************seata-account2003启动成功****************************************");
        } catch (Exception e) {
            log.error("seata-account2003启动失败",e);
        }
    }
}