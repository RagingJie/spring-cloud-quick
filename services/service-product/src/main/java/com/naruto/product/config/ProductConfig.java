package com.naruto.product.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductConfig {

    @LoadBalanced  // 使用注解的方式开启负载均衡
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
