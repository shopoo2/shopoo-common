package com.shopoo.common.sms.wap;

import com.shopoo.common.sms.api.SmsCaptchaFacade;
import com.shopoo.common.sms.api.SmsFacade;
import com.shopoo.common.sms.dto.cqe.CaptchaCheckCmd;
import com.shopoo.common.sms.dto.cqe.SmsSendCmd;
import com.szmengran.cola.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;

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
@Tag(name = "验证码")
@RestController
@RequestMapping(produces = { "application/json" })
public class SmsCaptchaController {
    
    @Resource
    private SmsCaptchaFacade smsCaptchaFacade;

    @Resource
    private SmsFacade smsFacade;
    
    @Operation(description = "发送短信登录验证码")
    @GetMapping("captcha/{phone}")
    public Response sendCaptcha(@PathVariable("phone") String phone) {
        SmsSendCmd smsSendCmd = SmsSendCmd
                .builder()
                .phone(phone)
                .num(4)
                .build();
        return smsFacade.send(smsSendCmd);
    }
    
    @Operation(description = "验证码检查是否正确")
    @GetMapping("/{captcha}/{phone}")
    public Response check(@PathVariable("captcha") String captcha, @PathVariable("phone") String phone) {
        CaptchaCheckCmd captchaCheckCmd = CaptchaCheckCmd.builder().captcha(captcha).phone(phone).build();
        return smsCaptchaFacade.check(captchaCheckCmd);
    }

}
