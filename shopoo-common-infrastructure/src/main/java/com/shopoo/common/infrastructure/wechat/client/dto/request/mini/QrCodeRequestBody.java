package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;

import java.io.Serializable;

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

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Boolean getAuto_color() {
		return auto_color;
	}

	public void setAuto_color(Boolean auto_color) {
		this.auto_color = auto_color;
	}

	public Object getLine_color() {
		return line_color;
	}

	public void setLine_color(Object line_color) {
		this.line_color = line_color;
	}

	public Boolean getIs_hyaline() {
		return is_hyaline;
	}

	public void setIs_hyaline(Boolean is_hyaline) {
		this.is_hyaline = is_hyaline;
	}
	
}
