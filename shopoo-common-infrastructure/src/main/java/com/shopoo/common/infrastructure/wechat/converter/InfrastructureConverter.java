package com.shopoo.common.infrastructure.wechat.converter;

import com.shopoo.common.domain.wechat.valueobject.MiniAppToken;
import com.shopoo.common.infrastructure.wechat.client.dto.response.mini.MiniAppTokenInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/26 2:39 PM
 */
@Mapper
public interface InfrastructureConverter {

	InfrastructureConverter INSTANCE = Mappers.getMapper(InfrastructureConverter.class);

	MiniAppToken toMiniAppToken(MiniAppTokenInfo miniAppTokenInfo);
}
