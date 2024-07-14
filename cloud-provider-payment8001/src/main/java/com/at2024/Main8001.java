package com.at2024;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.at2024.**.mapper")
public class Main8001 {
    private static Logger LOGGER = LoggerFactory.getLogger(Main8001.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(Main8001.class, args);
            LOGGER.info("****************************************cloud8001启动成功****************************************");
        } catch (Exception e) {
            LOGGER.error("cloud8001启动失败",e);
        }
    }
}