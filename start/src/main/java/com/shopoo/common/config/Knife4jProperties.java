package com.shopoo.common.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/27 6:34 PM
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "knife4j")
@Configuration
public class Knife4jProperties {

	private boolean swaggerDocEnable = false;
}
