package com.shopoo.common.wechat.dto.cqe.mini;

import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity.mini
 * @Description: 图文链接消息
 * @date Jan 9, 2019 9:44:55 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class LinkRequest extends AbstractRequest {
    private Link link;
}
