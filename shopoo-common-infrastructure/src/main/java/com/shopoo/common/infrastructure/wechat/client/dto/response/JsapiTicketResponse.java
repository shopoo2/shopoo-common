package com.shopoo.common.infrastructure.wechat.client.dto.response;

import lombok.Data;

/**
 * @Description: jsapi_ticket response
 * @Package com.szmengran.wechat.entity 
 * @CreateTime Mar 27, 2019 10:12:49 PM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Data
public class JsapiTicketResponse {
    private Integer errcode;
    private String errmsg;
    private String ticket;
    private Integer expires_in;
}
