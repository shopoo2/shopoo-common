package com.shopoo.common.wechat.dto.cqe.mini;

import com.shopoo.dto.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.szmengran.wechat.entity
 * @Description: 文本信息
 * @date Nov 24, 2018 11:24:40 AM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Text extends Command {
    private String content;
}
