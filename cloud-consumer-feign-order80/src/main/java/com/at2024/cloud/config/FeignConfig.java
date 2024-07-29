package com.at2024.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh
 * @date 2024-07-29 22:06:05
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer myRetryer()
    {
//        return Retryer.NEVER_RETRY; //Feign默认配置是不走重试策略的

        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
        /**
         * long period, 初始化时间配置，也就是100秒以后开始启动这个配置
         * long maxPeriod,最大的间隔时间
         * int maxAttempts 最大的重试次数
         */
        return new Retryer.Default(100,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
