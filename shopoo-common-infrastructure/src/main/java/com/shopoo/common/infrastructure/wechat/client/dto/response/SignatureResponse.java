package com.shopoo.common.infrastructure.wechat.client.dto.response;

import lombok.Data;

/**
 * @Description: 签名信息
 * @Package com.szmengran.wechat.entity 
 * @CreateTime Mar 27, 2019 10:47:40 PM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Data
public class SignatureResponse {
    private String appId;
    private String timestamp;
    private String nonceStr;
    private String signature;
}
