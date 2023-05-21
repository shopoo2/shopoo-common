package com.shopoo.common.wechat.dto.cqe;

import com.szmengran.cola.dto.Command;
import lombok.Data;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/20 11:03 AM
 */
@Data
public class WechatRegisterCmd extends Command {
	private String encryptedData;
	private String iv;
	private String code;
	private String openid;
	private String session_key;
}
