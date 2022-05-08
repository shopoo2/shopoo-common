package com.shopoo.common.infrastructure.wechat.client.dto.request;

import lombok.Data;

@Data
public class MsgSecCheckRequest {
    /**
     * 内容
     */
    private String content;
}
