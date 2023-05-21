package com.shopoo.common.wechat.dto.cqe.mini;

import com.szmengran.cola.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: TODO
 * @date Nov 20, 2018 10:06:50 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class Miniprogrampage extends Command {
    private String title;
    private String pagepath;
    private String thumb_media_id;
}
