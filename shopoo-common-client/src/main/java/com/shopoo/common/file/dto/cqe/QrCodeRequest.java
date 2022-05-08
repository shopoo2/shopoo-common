package com.shopoo.common.file.dto.cqe;

import com.shopoo.dto.Command;
import lombok.Data;

@Data
public class QrCodeRequest extends Command {

	private String appId;
	private String appSecret;

	private String scene;
	private String page;
	private Integer width;
	private Boolean auto_color;
	private Object line_color;
	private Boolean is_hyaline;

}
