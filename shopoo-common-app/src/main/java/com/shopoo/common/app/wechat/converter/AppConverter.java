package com.shopoo.common.app.wechat.converter;

import com.shopoo.common.wechat.dto.clientobject.JsapiTicketCO;
import com.shopoo.common.wechat.dto.clientobject.MiniAppTokenInfoCO;
import com.shopoo.common.wechat.dto.clientobject.OpenInfoCO;
import com.shopoo.common.wechat.dto.clientobject.SignatureCO;
import com.shopoo.common.wechat.dto.clientobject.TokenInfoCO;
import com.shopoo.common.wechat.dto.cqe.mini.ImageRequest;
import com.shopoo.common.wechat.dto.cqe.mini.LinkRequest;
import com.shopoo.common.wechat.dto.cqe.mini.MiniProgramPageRequest;
import com.shopoo.common.wechat.dto.cqe.mini.TextRequest;
import com.shopoo.common.wechat.dto.cqe.mini.UniformMessageRequest;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.ImageRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.LinkRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.MiniProgramPageRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.TextRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.UniformMessageRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.response.JsapiTicketResponse;
import com.shopoo.common.infrastructure.wechat.client.dto.response.OpenInfo;
import com.shopoo.common.infrastructure.wechat.client.dto.response.SignatureResponse;
import com.shopoo.common.infrastructure.wechat.client.dto.response.TokenInfo;
import com.shopoo.common.infrastructure.wechat.client.dto.response.mini.MiniAppTokenInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 *
 * @Author Joe
 * @Date 2022/3/14 6:42 PM
 */
@Mapper
public interface AppConverter {

	AppConverter INSTANCE = Mappers.getMapper(AppConverter.class);

	@Mappings({
			@Mapping(source = "expires_in", target = "expiresIn")
	})
	JsapiTicketCO toJsapiTicketCO(JsapiTicketResponse jsapiTicketResponse);

	@Mappings({
			@Mapping(source = "access_token", target = "accessToken"),
			@Mapping(source = "expires_in", target = "expiresIn")
	})
	MiniAppTokenInfoCO toMiniAppTokenInfoCO(MiniAppTokenInfo miniAppTokenInfo);

	@Mappings({
			@Mapping(source = "access_token", target = "accessToken"),
			@Mapping(source = "expires_in", target = "expiresIn"),
			@Mapping(source = "refresh_token", target = "refreshToken")
	})
	TokenInfoCO toTokenInfoCO(TokenInfo tokenInfo);

	SignatureCO toSignatureCO(SignatureResponse signatureResponse);

	OpenInfoCO toOpenInfoCO(OpenInfo openInfo);

	LinkRequestBody toLinkRequestBody(LinkRequest linkRequest);
	TextRequestBody toTextRequestBody(TextRequest textRequest);
	ImageRequestBody toImageRequestBody(ImageRequest imageRequest);
	MiniProgramPageRequestBody toMiniProgramPageRequestBody(MiniProgramPageRequest miniprogrampageRequest);
	UniformMessageRequestBody toUniformMessageRequestBody(UniformMessageRequest uniformMessageRequest);
}
