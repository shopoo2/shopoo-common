package com.shopoo.common.domain.sms.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/20 10:55 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Sms {
	private String phone;
	private String templatecode;
	private String templateparam;
	private String smsUpExtendCode;
	private String outid;

	// 生成短信验证码参数
	public void generateSmsTemplateparam(int num) {
		String captcha = generateCode(num);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", captcha);
		this.templateparam = new Gson().toJson(map);
	}

	private String generateCode(int num) {
		String str = "0123456789";
		StringBuilder sb = new StringBuilder(num);
		for (int i = 0; i < num; i++) {
			char ch = str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}
		return sb.toString();
	}
}
