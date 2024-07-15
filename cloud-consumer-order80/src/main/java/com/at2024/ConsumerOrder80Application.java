package com.at2024;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author lyh
 * @date 2024-07-15 23:11:41
 */
@SpringBootApplication
public class ConsumerOrder80Application {
    private static Logger logger = LoggerFactory.getLogger(ConsumerOrder80Application.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(ConsumerOrder80Application.class, args);
            logger.info("****************************************consumer80启动成功****************************************");
        } catch (Exception e) {
            logger.error("consumer80启动失败",e);
        }
    }
}