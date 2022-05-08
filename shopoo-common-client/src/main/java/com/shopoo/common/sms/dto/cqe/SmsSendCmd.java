package com.shopoo.common.sms.dto.cqe;

import com.shopoo.base.annotation.Phone;
import com.shopoo.dto.Command;
import io.swagger.annotations.ApiModelProperty;
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

	@ApiModelProperty("电话号码")
	@Phone
	private String phone;

	@ApiModelProperty("验证码长度")
	private int num;
}
