package com.shopoo.common.wechat.dto.cqe.mini;

import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: 下发小程序和公众号统一的服务消息
 * @date Nov 21, 2018 2:05:25 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class UniformMessageRequest extends AbstractRequest {
    private WeappTemplateMsg weapp_templateMsg;
}
