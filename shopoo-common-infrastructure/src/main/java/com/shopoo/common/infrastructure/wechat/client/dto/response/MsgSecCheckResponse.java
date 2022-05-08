package com.shopoo.common.infrastructure.wechat.client.dto.response;

import lombok.Data;

@Data
public class MsgSecCheckResponse {

    private Integer errcode;
    private String errmsg;
    
}
