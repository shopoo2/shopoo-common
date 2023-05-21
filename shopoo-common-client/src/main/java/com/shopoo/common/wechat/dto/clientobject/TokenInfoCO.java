package com.shopoo.common.wechat.dto.clientobject;

import com.szmengran.cola.dto.ClientObject;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: TODO
 * @date Nov 20, 2018 10:17:00 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class TokenInfoCO extends ClientObject {
    private String accessToken;
    private String expiresIn;
    private String refreshToken;
    private String openid;
    private String scope;
}
