package com.shopoo.common.domain.sms.repository;

import com.shopoo.common.domain.sms.entity.Sms;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/20 10:51 PM
 */
public interface SmsRepository {

	/**
	 * 短信发送
	 * @param sms
	 * @Return void
	 * @Date: 2022/3/20 11:00 PM
	 * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
	 */ 
	void send(Sms sms);
}
