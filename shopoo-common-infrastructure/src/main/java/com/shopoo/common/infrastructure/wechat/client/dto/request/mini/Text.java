package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;
/**
 * @Package com.szmengran.wechat.entity
 * @Description: 文本信息
 * @date Nov 24, 2018 11:24:40 AM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class Text {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Text() {
        
    }
    
    public Text(String content) {
        super();
        this.content = content;
    }
    
}
