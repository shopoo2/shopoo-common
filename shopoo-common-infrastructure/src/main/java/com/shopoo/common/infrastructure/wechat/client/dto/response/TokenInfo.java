package com.shopoo.common.infrastructure.wechat.client.dto.response;

import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: TODO
 * @date Nov 20, 2018 10:17:00 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class TokenInfo {
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private Integer errcode;
    private String errmsg;
}
