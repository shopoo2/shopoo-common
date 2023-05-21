package com.shopoo.common.wechat.dto.cqe.mini;

import com.szmengran.cola.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity.mini
 * @Description: TODO
 * @date Jan 9, 2019 9:46:15 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class Image extends Command {
    private String media_id;
}
