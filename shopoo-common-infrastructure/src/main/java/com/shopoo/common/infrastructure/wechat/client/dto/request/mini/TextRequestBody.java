package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;

import java.io.Serializable;

/**
 * @Package com.szmengran.wechat.entity.mini
 * @Description: 文本消息
 * @date Jan 9, 2019 9:44:55 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class TextRequestBody extends AbstractRequestBody implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 2745678923423423432L;
    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
    
}
