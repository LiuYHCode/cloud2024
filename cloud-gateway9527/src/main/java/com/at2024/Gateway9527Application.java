package com.at2024;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lyh
 * @date 2024-08-03 23:11:33
 */
@SpringBootApplication
public class Gateway9527Application {
    private static Logger logger = LoggerFactory.getLogger(Gateway9527Application.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(Gateway9527Application.class, args);
            logger.info("****************************************Gateway9527启动成功****************************************");
        } catch (Exception e) {
            logger.error("Gateway9527启动失败",e);
        }
    }
}