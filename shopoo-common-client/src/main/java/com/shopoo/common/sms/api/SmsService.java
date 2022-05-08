package com.shopoo.common.sms.api;

import com.shopoo.common.sms.dto.cqe.CommonSmsSendCmd;
import com.shopoo.common.sms.dto.cqe.SmsSendCmd;
import com.shopoo.dto.Response;

/**
 * @Package com.szmengran.cloud.common.sms.service
 * @Description: 短信发送服务
 * @date 2018年4月6日 下午2:12:13
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public interface SmsService {

    /**
     * 短信发送
     * @param commonSmsSendCmd
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    Response send(CommonSmsSendCmd commonSmsSendCmd);

    Response send(SmsSendCmd smsSendCmd);

    Response sendCaptcha(String phone);

}
