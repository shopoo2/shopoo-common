package com.shopoo.common.wechat.dto.cqe.mini;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shopoo.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: 小程序客服消息
 * @date Nov 22, 2018 7:46:29 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class ReceiveMessage extends Command {
    @JsonProperty(value = "ToUserName")
    private String ToUserName;
    @JsonProperty(value = "FromUserName")
    private String FromUserName;
    @JsonProperty(value = "CreateTime")
    private Long CreateTime;
    @JsonProperty(value = "MsgType")
    private String MsgType;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "MsgId")
    private String MsgId;
}
