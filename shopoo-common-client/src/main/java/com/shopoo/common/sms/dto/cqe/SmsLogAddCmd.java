package com.shopoo.common.sms.dto.cqe;

import java.time.LocalDateTime;

import com.shopoo.dto.Command;
import lombok.Data;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/22 12:57 AM
 */
@Data
public class SmsLogAddCmd extends Command {
	private Integer id;
	private String phone;
	private String signname;
	private String templatecode;
	private String templateparam;
	private String outid;
	private String result;
	private LocalDateTime createstamp;
	private LocalDateTime updatestamp;
}
