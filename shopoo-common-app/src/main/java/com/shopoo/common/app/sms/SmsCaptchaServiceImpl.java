package com.shopoo.common.app.sms;

import java.time.LocalDateTime;

import com.shopoo.common.app.sms.converter.AppConverter;
import com.shopoo.common.infrastructure.sms.repository.database.dataobject.TCommonSmsCaptcha;
import com.shopoo.common.infrastructure.sms.repository.database.mapper.SmsCaptchaMapper;
import com.shopoo.common.sms.api.SmsCaptchaService;
import com.shopoo.common.sms.dto.cqe.CaptchaAddCmd;
import com.shopoo.common.sms.dto.cqe.CaptchaCheckCmd;
import com.shopoo.common.sms.dto.cqe.CaptchaUpdateCmd;
import com.shopoo.dto.Response;
import com.shopoo.exception.Assert;
import com.shopoo.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @Package com.szmengran.cloud.common.sms.service.impl
 * @Description: 根据条件查询验证码信息
 * @date 2018年4月19日 下午4:22:41
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Service
@DubboService
public class SmsCaptchaServiceImpl implements SmsCaptchaService {
    
    @Autowired
    private SmsCaptchaMapper smsCaptchaMapper;

    @Override
    public Response check(@Validated CaptchaCheckCmd captchaCheckCmd) {
        String phone = captchaCheckCmd.getPhone();
        String captcha = captchaCheckCmd.getCaptcha();
        Assert.isTrue(StringUtils.isBlank(phone), "由于没有手机号码，阿里云短信发送不成功");
        Assert.isTrue(StringUtils.isBlank(captcha), "验证码不能为空");
        TCommonSmsCaptcha tCommonSmsCaptcha = smsCaptchaMapper.selectById(phone);
        if (tCommonSmsCaptcha == null || !captcha.equals(tCommonSmsCaptcha.getCaptcha())) {
            throw new BizException("验证码不正确，请重新输入");
        } else if (!checkTime(tCommonSmsCaptcha.getUpdatestamp(), 15*60)){
            throw new BizException("验证码已过期，请重新发送");
        }
        return Response.buildSuccess();
    }

    /**
     * 根据时间检查验证码是否过期
     * @param timestamp
     * @param seconds
     * @return
     * @return: Boolean
     * @throws
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    private boolean checkTime(LocalDateTime timestamp, Integer seconds) {
        return LocalDateTime.now().minusSeconds(seconds).isAfter(timestamp);
    }

    @Override
    public Response save(CaptchaAddCmd captchaAddCmd) {
        TCommonSmsCaptcha tCommonSmsCaptcha = AppConverter.INSTANCE.toTCommonSmsCaptcha(captchaAddCmd);
        smsCaptchaMapper.insert(tCommonSmsCaptcha);
        return Response.buildSuccess();
    }

//    @Override
//    public T_common_sms_captcha findByPrimaryKey(T_common_sms_captcha t_common_sms_captcha) throws Exception {
//        return smsCaptchaMapper.findById(t_common_sms_captcha);
//    }

    @Override
    public Response update(CaptchaUpdateCmd captchaUpdateCmd) {
        captchaUpdateCmd.setUpdatestamp(LocalDateTime.now());
        TCommonSmsCaptcha tCommonSmsCaptcha = AppConverter.INSTANCE.toTCommonSmsCaptcha(captchaUpdateCmd);
        smsCaptchaMapper.updateById(tCommonSmsCaptcha);
        return Response.buildSuccess();
    }

}
