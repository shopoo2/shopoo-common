package com.shopoo.common;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.shopoo.common.infrastructure.wechat.client", "com.shopoo.common.infrastructure.file.client"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
