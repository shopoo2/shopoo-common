package com.shopoo.common.wechat.dto.clientobject;

import com.google.gson.annotations.SerializedName;
import com.shopoo.dto.ClientObject;
import lombok.Data;

/**
 * @Package com.szmengran.user.entity
 * @Description: 微信用户授权信息
 * @date Jan 13, 2019 9:51:13 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class WechatRegisterCO extends ClientObject {
    
    @SerializedName("openId")
    private String openid;
    @SerializedName("nickName")
    private String nickname;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    @SerializedName("avatarUrl")
    private String avatarurl;
    @SerializedName("unionId")
    private String unionid;
    private Watermark watermark;
    private String code;

    @Data
    class Watermark {
        private long timestamp;
        private String appid;
    }
}
