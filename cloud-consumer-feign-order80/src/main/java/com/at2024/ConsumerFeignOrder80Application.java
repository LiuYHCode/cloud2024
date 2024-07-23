package com.at2024;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lyh
 * @date 2024-07-23 22:41:05
 */
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignOrder80Application {
    private static Logger logger = LoggerFactory.getLogger(ConsumerFeignOrder80Application.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(ConsumerFeignOrder80Application.class, args);
            logger.info("****************************************consumer80-feign启动成功****************************************");
        } catch (Exception e) {
            logger.error("consumer80-feign启动失败",e);
        }
    }
}