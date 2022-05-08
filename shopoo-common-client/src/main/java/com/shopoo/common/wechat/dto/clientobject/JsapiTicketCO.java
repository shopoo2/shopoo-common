package com.shopoo.common.wechat.dto.clientobject;

import com.shopoo.dto.ClientObject;
import lombok.Data;

/**
 * @Description: jsapi_ticket response
 * @Package com.szmengran.wechat.entity 
 * @CreateTime Mar 27, 2019 10:12:49 PM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Data
public class JsapiTicketCO extends ClientObject {
    private String ticket;
    private Integer expiresIn;
}
