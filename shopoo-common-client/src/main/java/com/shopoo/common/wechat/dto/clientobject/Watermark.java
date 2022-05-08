package com.shopoo.common.wechat.dto.clientobject;

import com.shopoo.dto.ClientObject;
import lombok.Data;

/**
 * @Package com.szmengran.user.entity
 * @Description: TODO
 * @date Jan 13, 2019 9:53:10 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class Watermark extends ClientObject {
    private long timestamp;
    private String appid;
}
