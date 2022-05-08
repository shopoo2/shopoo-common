package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: 小程序客服消息
 * @date Nov 22, 2018 7:46:29 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class ReceiveMessage {
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
    public String getToUserName() {
        return ToUserName;
    }
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }
    public String getFromUserName() {
        return FromUserName;
    }
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }
    public Long getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }
    public String getMsgType() {
        return MsgType;
    }
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
    public String getMsgId() {
        return MsgId;
    }
    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
    
}
