package com.shopoo.common.app.sms.converter;

import com.shopoo.common.domain.sms.entity.Sms;
import com.shopoo.common.infrastructure.sms.repository.database.dataobject.TCommonSmsCaptcha;
import com.shopoo.common.infrastructure.sms.repository.database.dataobject.TCommonSmsLog;
import com.shopoo.common.sms.dto.clientobject.SmsLogCO;
import com.shopoo.common.sms.dto.cqe.CaptchaAddCmd;
import com.shopoo.common.sms.dto.cqe.CaptchaCheckCmd;
import com.shopoo.common.sms.dto.cqe.CaptchaUpdateCmd;
import com.shopoo.common.sms.dto.cqe.CommonSmsSendCmd;
import com.shopoo.common.sms.dto.cqe.SmsLogAddCmd;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/20 11:54 PM
 */
@Mapper
public interface AppConverter {

	AppConverter INSTANCE = Mappers.getMapper(AppConverter.class);

	TCommonSmsLog toTCommonSmsLog(Sms sms);
	TCommonSmsLog toTCommonSmsLog(SmsLogAddCmd smsLogAddCmd);
	SmsLogCO toSmsLogCO(TCommonSmsLog tCommonSmsLog);
	Sms toSms(CommonSmsSendCmd commonSmsSendCmd);

	TCommonSmsCaptcha toTCommonSmsCaptcha(CaptchaUpdateCmd captchaUpdateCmd);
	TCommonSmsCaptcha toTCommonSmsCaptcha(CaptchaAddCmd captchaAddCmd);
	TCommonSmsCaptcha toTCommonSmsCaptcha(CaptchaCheckCmd captchaCheckCmd);
}
