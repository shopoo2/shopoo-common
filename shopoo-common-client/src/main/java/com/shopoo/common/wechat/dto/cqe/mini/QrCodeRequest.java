package com.shopoo.common.wechat.dto.cqe.mini;

import com.szmengran.cola.dto.ClientObject;
import lombok.Data;

@Data
public class QrCodeRequest extends ClientObject {

	private String scene;
	private String page;
	private Integer width;
	private Boolean auto_color;
	private Object line_color;
	private Boolean is_hyaline;

}
