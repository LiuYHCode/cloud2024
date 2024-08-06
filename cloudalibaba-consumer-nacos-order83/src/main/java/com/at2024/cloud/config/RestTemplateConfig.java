package com.at2024.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lyh
 * @date 2024-08-05 23:46:01
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced  //赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
