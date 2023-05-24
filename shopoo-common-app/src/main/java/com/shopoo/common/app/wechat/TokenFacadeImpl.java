package com.shopoo.common.app.wechat;

import com.google.gson.Gson;
import com.shopoo.common.app.wechat.converter.AppConverter;
import com.shopoo.common.infrastructure.wechat.client.WechatClient;
import com.shopoo.common.infrastructure.wechat.client.dto.response.OpenInfo;
import com.shopoo.common.infrastructure.wechat.client.dto.response.TokenInfo;
import com.shopoo.common.infrastructure.wechat.client.dto.response.mini.MiniAppTokenInfo;
import com.shopoo.common.wechat.api.TokenFacade;
import com.shopoo.common.wechat.dto.clientobject.MiniAppTokenInfoCO;
import com.shopoo.common.wechat.dto.clientobject.OpenInfoCO;
import com.shopoo.common.wechat.dto.clientobject.TokenInfoCO;
import com.shopoo.common.wechat.dto.cqe.ApiTokenQry;
import com.shopoo.common.wechat.dto.cqe.MiniAppTokenQry;
import com.shopoo.common.wechat.dto.cqe.TokenQry;
import com.shopoo.common.wechat.dto.cqe.WechatInfoQry;
import com.szmengran.cola.dto.SingleResponse;
import com.szmengran.cola.exception.BizException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Package com.szmengran.wechat.token.service.impl
 * @Description: 微信Token服务
 * @date 2018年9月5日 上午9:38:08
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Slf4j
@Service
@DubboService
public class TokenFacadeImpl implements TokenFacade {

    @Resource
    private WechatClient wechatClient;
    
    @Cacheable(value = "wechatMiniAppToken", key = "#miniAppTokenQry.appId")
    @Override
    public SingleResponse<MiniAppTokenInfoCO> getMiniAppToken(MiniAppTokenQry miniAppTokenQry) {
        MiniAppTokenInfo miniAppTokenInfo = wechatClient.getMiniAppToken(miniAppTokenQry.getAppId(), miniAppTokenQry.getAppSecret());
        return SingleResponse.of(AppConverter.INSTANCE.toMiniAppTokenInfoCO(miniAppTokenInfo));
    }
    
    @CacheEvict(allEntries = true, value = "wechatMiniAppToken")
    @Scheduled(fixedDelay = 2 * 45 * 60 * 1000 ,  initialDelay = 2 * 45 * 60 * 1000)
    public void wechatCacheEvict() {
        log.debug("remove wechatMiniAppToken cache");
    }
    
    @Cacheable(value = "wechatToken", key = "#tokenQry.code")
    @Override
    public SingleResponse<TokenInfoCO> getToken(TokenQry tokenQry) {
        String json = wechatClient.getToken(tokenQry.getAppId(), tokenQry.getAppSecret(), tokenQry.getCode());
        TokenInfo tokenInfo = new Gson().fromJson(json, TokenInfo.class);
        if (tokenInfo.getErrcode() != null) {
            throw new BizException(tokenInfo.getErrcode()+"", tokenInfo.getErrmsg());
        }
        return SingleResponse.of(AppConverter.INSTANCE.toTokenInfoCO(tokenInfo));
    }

    @Cacheable(value = "wechatToken", key = "#apiTokenQry.appId")
    @Override
    public SingleResponse<TokenInfoCO> getApiToken(ApiTokenQry apiTokenQry) {
        TokenInfo tokenInfo =  wechatClient.getApiToken(apiTokenQry.getAppId(), apiTokenQry.getAppSecret());
        if (tokenInfo.getErrcode() != null) {
            throw new BizException(tokenInfo.getErrcode()+"", tokenInfo.getErrmsg());
        }
        return SingleResponse.of(AppConverter.INSTANCE.toTokenInfoCO(tokenInfo));
    }

    @Override
    public SingleResponse<OpenInfoCO> getBaseInfo(WechatInfoQry wechatInfoQry) {
        String json = wechatClient.getToken(wechatInfoQry.getAppId(), wechatInfoQry.getAppSecret(), wechatInfoQry.getCode());
        TokenInfo tokenInfo = new Gson().fromJson(json, TokenInfo.class);
        if (tokenInfo.getErrcode() != null) {
            throw new BizException(tokenInfo.getErrcode()+"", tokenInfo.getErrmsg());
        }
        OpenInfo openInfo = new OpenInfo();
        openInfo.setOpenid(tokenInfo.getOpenid());
        return SingleResponse.of(AppConverter.INSTANCE.toOpenInfoCO(openInfo));
    }

    @Override
    public SingleResponse<OpenInfoCO> getUserInfo(WechatInfoQry wechatInfoQry) {
        String json = wechatClient.getToken(wechatInfoQry.getAppId(), wechatInfoQry.getAppSecret(), wechatInfoQry.getCode());
        TokenInfo tokenInfo = new Gson().fromJson(json, TokenInfo.class);
        if (tokenInfo.getErrcode() != null) {
            throw new BizException(tokenInfo.getErrcode()+"", tokenInfo.getErrmsg());
        }
        OpenInfo openInfo = new Gson().fromJson(wechatClient.getOpenInfo(tokenInfo.getAccess_token(), wechatInfoQry.getCode()), OpenInfo.class);
        //当授权类型不是snsapi_userinfo时，获取不到unionid的信息，所以直接返回openid信息
        if (openInfo == null || StringUtils.isBlank(openInfo.getUnionid())) {
            openInfo = new OpenInfo();
            openInfo.setOpenid(tokenInfo.getOpenid());
        }
        return SingleResponse.of(AppConverter.INSTANCE.toOpenInfoCO(openInfo));
    }
}
