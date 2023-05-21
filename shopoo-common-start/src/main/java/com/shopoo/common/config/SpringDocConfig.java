package com.shopoo.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author MaoYuan.Li
 * @Date 2022/5/19 20:22
 * @Version 1.0
 */
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Common API").version("1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
    
}
