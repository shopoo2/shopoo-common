package com.shopoo.common.domain.sms.config;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/20 6:44 PM
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "aliyun.sms")
@Configuration
public class SmsProperties {
	private TemplateCode templatecode = new TemplateCode();
	private String signname;
	private String accessKeyID;
	private String accessKeySecret;
	private String endpoint;

	@NoArgsConstructor
	@Getter
	@Setter
	public class TemplateCode {
		private String captcha;
	}
}
