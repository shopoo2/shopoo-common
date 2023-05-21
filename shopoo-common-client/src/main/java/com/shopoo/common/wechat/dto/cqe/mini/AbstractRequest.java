package com.shopoo.common.wechat.dto.cqe.mini;

import com.szmengran.cola.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: 发送消息给小程序用户
 * @date Jan 9, 2019 9:42:46 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class AbstractRequest extends Command {
    private String appId;
    private String appSecret;
    private String touser;
    private String msgtype;
}
