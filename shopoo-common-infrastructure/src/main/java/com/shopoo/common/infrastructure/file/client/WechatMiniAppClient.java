package com.shopoo.common.infrastructure.file.client;

import com.shopoo.common.infrastructure.file.client.dto.QrCodeRequestBody;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "wechatMiniApi", url = "https://api.weixin.qq.com")
public interface WechatMiniAppClient {

	@PostMapping("/wxa/getwxacodeunlimit?access_token={access_token}")
	byte[] getwxacodeunlimit(@PathVariable("access_token") String access_token, @RequestBody QrCodeRequestBody qrCodeRequestBody);
}
