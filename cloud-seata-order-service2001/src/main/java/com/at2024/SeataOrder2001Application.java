package com.at2024;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lyh
 * @date 2024-08-11 17:03:34
 */
@SpringBootApplication
@MapperScan("com.at2024.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //服务注册和发现
@EnableFeignClients
@Slf4j
public class SeataOrder2001Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SeataOrder2001Application.class, args);
            log.info("****************************************NacosConfig3377启动成功****************************************");
        } catch (Exception e) {
            log.error("NacosConfig3377启动失败",e);
        }
    }
}