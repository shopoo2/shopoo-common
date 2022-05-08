package com.shopoo.common.domain.wechat.valueobject;

import lombok.Data;

/**
 * @Description: 小程序token
 * @Package com.szmengran.wechat.entity.mini 
 * @CreateTime Mar 22, 2019 11:13:25 AM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Data
public class MiniAppToken {
    private String access_token;
    private String expires_in;
    private Integer errcode;
    private String errmsg;
}
