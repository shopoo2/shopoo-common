package com.shopoo.common.wechat.dto.cqe.mini;

import java.util.Map;

import com.szmengran.cola.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: TODO
 * @date Nov 21, 2018 2:07:03 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class WeappTemplateMsg extends Command {
    private String template_id;
    private String page;
    private String form_id;
    private Map<String, Value> data;
    private String emphasis_keyword;
}
