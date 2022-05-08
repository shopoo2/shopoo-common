package com.shopoo.common.wechat.dto.cqe.mini;

import com.shopoo.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity.mini
 * @Description: TODO
 * @date Jan 9, 2019 9:48:13 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class Link extends Command {
    private String title;
    private String description;
    private String url;
    private String thumb_url;
}
