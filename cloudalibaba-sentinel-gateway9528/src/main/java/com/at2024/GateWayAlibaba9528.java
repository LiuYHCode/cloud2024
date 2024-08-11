package com.at2024;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyh
 * @date 2024-08-11 12:07:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayAlibaba9528 {
    private static Logger logger = LoggerFactory.getLogger(GateWayAlibaba9528.class);
    public static void main(String[] args) {
        try {
            SpringApplication.run(GateWayAlibaba9528.class, args);
            logger.info("****************************************GateWay9528启动成功****************************************");
        } catch (Exception e) {
            logger.error("GateWay9528启动失败",e);
        }
    }
}