package com.shopoo.common.wechat.dto.cqe;

import javax.validation.constraints.NotBlank;

import com.shopoo.dto.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/27 2:06 AM
 */
@AllArgsConstructor
@NotBlank
@Builder
@Data
public class SignatureCheckCmd extends Command {
	private String encodingAESKey;
	private String appId;
	private String myToken;
	private String timestamp;
	private String nonce;
	private String echostr;
	private String signature;
}
