package com.shopoo.common.domain.wechat.repository;

import com.shopoo.common.domain.wechat.valueobject.MiniAppToken;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/26 2:37 PM
 */
public interface WechatRepository {

	MiniAppToken getMiniAppToken(String appId, String appSecret);

}
