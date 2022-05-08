package com.shopoo.common.sms.wap;

import com.shopoo.common.sms.api.SmsService;
import com.shopoo.common.sms.dto.cqe.SmsSendCmd;
import com.shopoo.dto.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.szmengran.cloud.common.sms.controller
 * @Description: 短信服务
 * @date 2018年4月6日 下午3:10:00
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Api("短信发送")
@RestController
@RequestMapping(produces = { "application/json" })
public class SmsController {
    
    @Autowired
    private SmsService smsService;
    
    @ApiOperation(value = "发送短信服务", response = Response.class)
    @PostMapping("/message")
    public Response send(@Validated @RequestBody SmsSendCmd smsSendCmd) {
        return smsService.send(smsSendCmd);
    }
    
}
