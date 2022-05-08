package com.shopoo.common.infrastructure.sms.repository;

import javax.annotation.Resource;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.google.gson.Gson;
import com.shopoo.common.domain.sms.config.SmsProperties;
import com.shopoo.common.domain.sms.entity.Sms;
import com.shopoo.common.domain.sms.repository.SmsRepository;
import com.shopoo.exception.SysException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/20 11:00 PM
 */
@Slf4j
@Repository
public class SmsRepositoryImpl implements SmsRepository, InitializingBean {

	@Resource
	private SmsProperties smsProperties;

	private Client client;

	@Override
	public void send(Sms sms) {
		SendSmsRequest sendSmsRequest = new SendSmsRequest()
				.setPhoneNumbers(sms.getPhone())
				.setSignName(smsProperties.getSignname())
				.setTemplateCode(sms.getTemplatecode())
				.setTemplateParam(sms.getTemplateparam())
				.setSmsUpExtendCode(sms.getSmsUpExtendCode())
				.setOutId(sms.getOutid());

		log.info("发送短信：{}", new Gson().toJson(sendSmsRequest));
		// 复制代码运行请自行打印 API 的返回值
		try {
			SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
			if (!"OK".equals(sendSmsResponse.getBody().getCode())) {
				throw new SysException(sendSmsResponse.getBody().getMessage());
			}
			log.info("发送短信结果：{}", new Gson().toJson(sendSmsResponse));
		}
		catch (Exception e) {
			throw new SysException(e.getMessage(), e);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Config config = new Config()
				.setEndpoint(smsProperties.getEndpoint())
				// 您的AccessKey ID
				.setAccessKeyId(smsProperties.getAccessKeyID())
				// 您的AccessKey Secret
				.setAccessKeySecret(smsProperties.getAccessKeySecret());
		client = new Client(config);
	}
}
