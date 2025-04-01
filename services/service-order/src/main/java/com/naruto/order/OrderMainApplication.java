package com.naruto.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient // 启用服务发现
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
        log.info("===================================================");
        log.info("OrderMainApplication started ！！！");
        log.info("===================================================");
    }


    // 1、项目启动就能监听配置文件变化
    // 2、发生变化后拿到变化值
    // 3、发送邮件、短信、通知等
    // ApplicationRunner作用是在项目启动后执行，并且只执行一次
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager) {
        return args -> {
            System.out.println("====================== 该方法只在项目启动时，执行一次 ============================");
            // 获取配置文件
            ConfigService configService = nacosConfigManager.getConfigService();
            // 监听配置文件变化--添加监听器【参数1--配置文件名称（dataId），参数2--命名空间（group），参数3--监听器】
            configService.addListener("service-order.properties", "DEFAULT_GROUP", new Listener() {
                @Override
                public Executor getExecutor() {
                    return Executors.newFixedThreadPool(10);
                }

                @Override
                public void receiveConfigInfo(String s) {
                    System.out.println("配置文件发生变化，新的值：" + s);
                }
            });
        };
    }
}