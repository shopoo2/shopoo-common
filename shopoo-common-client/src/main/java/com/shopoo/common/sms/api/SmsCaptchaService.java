package com.shopoo.common.sms.api;

import com.shopoo.common.sms.dto.cqe.CaptchaAddCmd;
import com.shopoo.common.sms.dto.cqe.CaptchaCheckCmd;
import com.shopoo.common.sms.dto.cqe.CaptchaUpdateCmd;
import com.shopoo.dto.Response;

/**
 * @Package com.szmengran.cloud.common.sms.service
 * @Description: 短信验证码服务
 * @date 2018年4月19日 下午4:22:12
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public interface SmsCaptchaService {

    Response check(CaptchaCheckCmd captchaCheckCmd);

    /**
     * 保存短信记录
     * @param captchaAddCmd
     * @return: void
     * @throws   
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    Response save(CaptchaAddCmd captchaAddCmd);

    /**
     * 更新短信验证码信息
     * @param captchaUpdateCmd
     * @return: int
     * @throws   
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    Response update(CaptchaUpdateCmd captchaUpdateCmd);
}
