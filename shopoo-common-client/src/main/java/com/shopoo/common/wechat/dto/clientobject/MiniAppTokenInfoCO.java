package com.shopoo.common.wechat.dto.clientobject;

import com.szmengran.cola.dto.ClientObject;
import lombok.Data;

/**
 * @Description: 小程序token
 * @Package com.szmengran.wechat.entity.mini 
 * @CreateTime Mar 22, 2019 11:13:25 AM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Data
public class MiniAppTokenInfoCO extends ClientObject {
    private String accessToken;
    private String expiresIn;
}
