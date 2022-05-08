package com.shopoo.common.infrastructure.wechat.client.dto.request;
/** 
 * @Description: 微信获取config的签名实体
 * @Package com.szmengran.wechat.entity 
 * @CreateTime Mar 27, 2019 10:27:24 PM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
public class SignatureRequest {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
