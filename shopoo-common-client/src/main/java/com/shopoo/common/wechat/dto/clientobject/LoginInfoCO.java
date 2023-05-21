package com.shopoo.common.wechat.dto.clientobject;

import com.szmengran.cola.dto.ClientObject;
import lombok.Data;

/**
 * @Description: 微信小程序登录信息
 * @Package com.szmengran.wechat.entity.mini 
 * @CreateTime Mar 22, 2019 9:34:37 AM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Data
public class LoginInfoCO extends ClientObject {
    private String openid;
    private String session_key;
    private String unionid;
    private Integer errcode;
    private String errmsg;
}
