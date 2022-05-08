package com.shopoo.common.infrastructure.wechat.repository;

import javax.annotation.Resource;

import com.shopoo.common.domain.wechat.repository.WechatRepository;
import com.shopoo.common.domain.wechat.valueobject.MiniAppToken;
import com.shopoo.common.infrastructure.wechat.client.WechatClient;
import com.shopoo.common.infrastructure.wechat.client.dto.response.mini.MiniAppTokenInfo;
import com.shopoo.common.infrastructure.wechat.converter.InfrastructureConverter;

import org.springframework.stereotype.Repository;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/26 2:42 PM
 */
@Repository
public class WechatRepositoryImpl implements WechatRepository {

	@Resource
	private WechatClient wechatClient;

	@Override
	public MiniAppToken getMiniAppToken(String appId, String appSecret) {
		MiniAppTokenInfo miniAppTokenInfo = wechatClient.getMiniAppToken(appId, appSecret);
		return InfrastructureConverter.INSTANCE.toMiniAppToken(miniAppTokenInfo);
	}
}
