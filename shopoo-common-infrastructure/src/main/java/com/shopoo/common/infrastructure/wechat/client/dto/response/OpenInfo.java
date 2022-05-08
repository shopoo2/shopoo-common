package com.shopoo.common.infrastructure.wechat.client.dto.response;

import lombok.Data;

/** 
 * @Description: 微信公众平台开放用户信息
 * @Package com.szmengran.wechat.entity 
 * @CreateTime Mar 22, 2019 8:46:47 AM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Data
public class OpenInfo {
    private String openid;
    private String nickname;
    private String sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private String unionid;
    private String errcode;
    private String errmsg;
}
