package com.shopoo.common.wechat.api;

import com.shopoo.common.wechat.dto.clientobject.MiniAppTokenInfoCO;
import com.shopoo.common.wechat.dto.clientobject.OpenInfoCO;
import com.shopoo.common.wechat.dto.clientobject.TokenInfoCO;
import com.shopoo.common.wechat.dto.cqe.ApiTokenQry;
import com.shopoo.common.wechat.dto.cqe.MiniAppTokenQry;
import com.shopoo.common.wechat.dto.cqe.TokenQry;
import com.shopoo.common.wechat.dto.cqe.WechatInfoQry;
import com.shopoo.dto.SingleResponse;

/**
 * @Package com.szmengran.wechat.token.service
 * @Description: 获取Token服务
 * @date 2018年9月4日 下午4:36:39
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public interface TokenService {

    /**
     * 微信小程序获取token
     * @Date: 2022/3/14 6:27 PM
     * @Author: Joe
     * 
     * @param miniAppTokenQry
     * @return com.shopoo.dto.SingleResponse<com.shopoo.wechat.dto.clientobject.MiniAppTokenInfoCO>
     */ 
    SingleResponse<MiniAppTokenInfoCO> getMiniAppToken(MiniAppTokenQry miniAppTokenQry);
    
    /**
     * 微信公众号获取token
     * @Date: 2022/3/14 6:27 PM
     * @Author: Joe
     * 
     * @param tokenQry
     * @return com.shopoo.dto.SingleResponse<com.shopoo.wechat.dto.clientobject.TokenInfoCO>
     */ 
    SingleResponse<TokenInfoCO> getToken(TokenQry tokenQry);
    
    /**
     * 获取平台api调用的token
     * @Date: 2022/3/14 6:27 PM
     * @Author: Joe
     * 
     * @param apiTokenQry
     * @return com.shopoo.dto.SingleResponse<com.shopoo.wechat.dto.clientobject.TokenInfoCO>
     */ 
    SingleResponse<TokenInfoCO> getApiToken(ApiTokenQry apiTokenQry);

    SingleResponse<OpenInfoCO> getBaseInfo(WechatInfoQry wechatInfoQry);
    SingleResponse<OpenInfoCO> getUserInfo(WechatInfoQry wechatInfoQry);
}
