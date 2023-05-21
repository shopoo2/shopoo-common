package com.shopoo.common.sms.dto.cqe;

import com.szmengran.cola.base.annotation.Phone;
import com.szmengran.cola.dto.Command;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/20 10:26 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SmsSendCmd extends Command {

	@Schema(name = "电话号码")
	@Phone
	private String phone;

	@Schema(name = "验证码长度")
	private int num;
}
