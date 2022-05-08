package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;

/**
 * @Package com.szmengran.wechat.entity.mini
 * @Description: 图文链接消息
 * @date Jan 9, 2019 9:44:55 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class LinkRequestBody extends AbstractRequestBody {
    private Link link;

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
    
}
