package com.at2024;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lyh
 * @date 2024-07-21 22:07:18
 */
@SpringBootApplication
@MapperScan("com.at2024.**.mapper")
@EnableDiscoveryClient//开启服务发现
@RefreshScope//动态刷新consul服务器配置
public class ProviderPayment8002Application {
    private static Logger LOGGER = LoggerFactory.getLogger(ProviderPayment8002Application.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(ProviderPayment8002Application.class, args);
            LOGGER.info("****************************************cloud8001启动成功****************************************");
        } catch (Exception e) {
            LOGGER.error("cloud8001启动失败",e);
        }
    }
}