package com.shopoo.common.file.dto.cqe;

import java.time.LocalDateTime;

import com.shopoo.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.file.service.entity
 * @Description: TODO
 * @date Feb 21, 2019 6:55:28 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class ImageAddCmd extends Command {
	private String fileid;
	private String userid;
	private String type;
	private String suffix;
	private String orgname;
	private Long filesize;
	private String validstatus;
	private LocalDateTime createstamp;
}
