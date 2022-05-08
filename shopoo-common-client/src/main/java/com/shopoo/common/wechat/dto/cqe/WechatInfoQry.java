package com.shopoo.common.wechat.dto.cqe;

import com.shopoo.dto.Query;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/26 2:06 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WechatInfoQry extends Query {
	private String appId;
	private String appSecret;
	private String code;
}
