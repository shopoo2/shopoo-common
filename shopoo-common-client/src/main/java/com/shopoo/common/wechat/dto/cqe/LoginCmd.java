package com.shopoo.common.wechat.dto.cqe;

import com.szmengran.cola.dto.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/26 3:15 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginCmd extends Command {
	private String appId;
	private String appSecret;
	private String code;
}
