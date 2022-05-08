package com.shopoo.common.app.sms;

import javax.annotation.Resource;

import com.shopoo.common.app.sms.converter.AppConverter;
import com.shopoo.common.domain.sms.config.SmsProperties;
import com.shopoo.common.domain.sms.entity.Sms;
import com.shopoo.common.domain.sms.repository.SmsRepository;
import com.shopoo.common.infrastructure.sms.repository.database.dataobject.TCommonSmsCaptcha;
import com.shopoo.common.infrastructure.sms.repository.database.dataobject.TCommonSmsLog;
import com.shopoo.common.infrastructure.sms.repository.database.mapper.SmsCaptchaMapper;
import com.shopoo.common.infrastructure.sms.repository.database.mapper.SmsLogMapper;
import com.shopoo.common.sms.api.SmsService;
import com.shopoo.common.sms.dto.cqe.CommonSmsSendCmd;
import com.shopoo.common.sms.dto.cqe.SmsSendCmd;
import com.shopoo.dto.Response;
import com.shopoo.exception.SysException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @Package com.szmengran.cloud.common.sms.service.impl
 * @Description: 短信发送服务
 * @date 2018年4月6日 下午2:17:37
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Slf4j
@DubboService
@Service
public class SmsServiceImpl implements SmsService {
    
    @Resource
    private SmsLogMapper smsLogMapper;
    
    @Resource
    private SmsCaptchaMapper smsCaptchaMapper;

    @Resource
    private SmsRepository smsRepository;

    @Resource
    private SmsProperties smsProperties;
    
    @Override
    public Response send(CommonSmsSendCmd commonSmsSendCmd) {
        Sms sms = AppConverter.INSTANCE.toSms(commonSmsSendCmd);
        smsRepository.send(sms);
        TCommonSmsLog tCommonSmsLog = AppConverter.INSTANCE.toTCommonSmsLog(sms);
        smsLogMapper.insert(tCommonSmsLog);
        return Response.buildSuccess();
    }

    @Override
    public Response send(SmsSendCmd smsSendCmd) {
        Sms sms = Sms
                .builder()
                .phone(smsSendCmd.getPhone())
                .templatecode(smsProperties.getTemplatecode().getCaptcha())
                .build();
        sms.generateSmsTemplateparam(smsSendCmd.getNum());
        smsRepository.send(sms);
        TCommonSmsLog tCommonSmsLog = AppConverter.INSTANCE.toTCommonSmsLog(sms);
        smsLogMapper.insert(tCommonSmsLog);
        return Response.buildSuccess();
    }

    @Override
    public Response sendCaptcha(String phone) {
        Sms sms = Sms
                .builder()
                .phone(phone)
                .templatecode(smsProperties.getTemplatecode().getCaptcha())
                .build();
        sms.generateSmsTemplateparam(4);
        smsRepository.send(sms);
        
        TCommonSmsCaptcha tCommonSmsCaptcha = new TCommonSmsCaptcha();
        tCommonSmsCaptcha.setCaptcha(sms.getTemplatecode());
        tCommonSmsCaptcha.setPhone(phone);
        try {
            smsCaptchaMapper.insert(tCommonSmsCaptcha);
        } catch (DuplicateKeyException e) {
            log.warn("短信验证码重复：{}", e.getMessage());
            smsCaptchaMapper.updateById(tCommonSmsCaptcha);
        } catch (Exception e) {
            throw new SysException("保存短信验证码失败", e);
        }
        return Response.buildSuccess();
    }
}
