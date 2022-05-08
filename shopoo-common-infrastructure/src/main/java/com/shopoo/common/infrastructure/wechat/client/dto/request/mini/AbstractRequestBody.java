package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;
/**
 * @Package com.szmengran.wechat.entity
 * @Description: 发送消息给小程序用户
 * @date Jan 9, 2019 9:42:46 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class AbstractRequestBody {
    private String touser;
    private String msgtype;
    public String getTouser() {
        return touser;
    }
    public void setTouser(String touser) {
        this.touser = touser;
    }
    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    
}
