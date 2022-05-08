package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;

import java.io.Serializable;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: TODO
 * @date Nov 20, 2018 10:02:18 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class MsgResponse implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 124873276823423423L;
    private Integer errcode;
    private String errmsg;
    public Integer getErrcode() {
        return errcode;
    }
    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    
}
