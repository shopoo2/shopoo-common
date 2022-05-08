package com.shopoo.common.infrastructure.file.repository.database.dataobject;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Package com.szmengran.file.service.entity
 * @Description: TODO
 * @date Feb 21, 2019 6:55:28 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class Image {
	@TableId
	private String fileid;
	private String userid;
	private String type;
	private String suffix;
	private String orgname;
	private Long filesize;
	private String validstatus;
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createstamp;
}
