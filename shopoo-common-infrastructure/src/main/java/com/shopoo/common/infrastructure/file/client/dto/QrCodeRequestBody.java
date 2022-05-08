package com.shopoo.common.infrastructure.file.client.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class QrCodeRequestBody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8395098914384001633L;
	private String scene;
	private String page;
	private Integer width;
	private Boolean auto_color;
	private Object line_color;
	private Boolean is_hyaline;

}
