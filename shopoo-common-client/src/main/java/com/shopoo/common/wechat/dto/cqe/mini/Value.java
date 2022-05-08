package com.shopoo.common.wechat.dto.cqe.mini;

import com.shopoo.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: TODO
 * @date Nov 21, 2018 2:11:13 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class Value extends Command {
    private String value;
    private String color;
}
