package com.shopoo.common.wechat.dto.clientobject;

import com.shopoo.dto.ClientObject;
import lombok.Data;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/26 1:53 AM
 */
@Data
public class SignatureCO extends ClientObject {
	private String appId;
	private String timestamp;
	private String nonceStr;
	private String signature;
}
