package com.shopoo.common.infrastructure.file.config;

import lombok.Data;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/27 4:18 AM
 */
@Data
@ConfigurationProperties(prefix = "aliyun.oss")
@Configuration
public class AliyunProperties {
	private String accessKeyId;
	private String accessKeySecret;
	private String bucket;
	private String endpoint;
	private String host;
	private Integer maxFileSize;
}
