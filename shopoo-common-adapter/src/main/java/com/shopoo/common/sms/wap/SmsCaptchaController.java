package com.shopoo.common.sms.wap;

import javax.annotation.Resource;

import com.shopoo.common.sms.api.SmsCaptchaService;
import com.shopoo.common.sms.api.SmsService;
import com.shopoo.common.sms.dto.cqe.CaptchaCheckCmd;
import com.shopoo.common.sms.dto.cqe.SmsSendCmd;
import com.shopoo.dto.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.szmengran.cloud.common.sms.controller
 * @Description: 短信服务
 * @date 2018年4月6日 下午3:10:00
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Api("验证码")
@RestController
@RequestMapping(produces = { "application/json" })
public class SmsCaptchaController {
    
    @Resource
    private SmsCaptchaService smsCaptchaService;

    @Resource
    private SmsService smsService;
    
    @ApiOperation(value = "发送短信登录验证码", response = Response.class)
    @GetMapping("captcha/{phone}")
    public Response sendCaptcha(@PathVariable("phone") String phone) {
        SmsSendCmd smsSendCmd = SmsSendCmd
                .builder()
                .phone(phone)
                .num(4)
                .build();
        return smsService.send(smsSendCmd);
    }
    
    @ApiOperation(value = "验证码检查是否正确", response = Response.class)
    @GetMapping("/{captcha}/{phone}")
    public Response check(@PathVariable("captcha") String captcha, @PathVariable("phone") String phone) {
        CaptchaCheckCmd captchaCheckCmd = CaptchaCheckCmd.builder().captcha(captcha).phone(phone).build();
        return smsCaptchaService.check(captchaCheckCmd);
    }

}
