package com.shopoo.common.wechat.dto.cqe.mini;

import com.szmengran.cola.dto.ClientObject;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: TODO
 * @date Nov 20, 2018 10:02:18 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class MsgResponse extends ClientObject {
    private Integer errcode;
    private String errmsg;
}
