package com.shopoo.common.wechat.mobile;

import com.shopoo.common.infrastructure.wechat.client.dto.request.MsgSecCheckRequest;
import com.shopoo.common.infrastructure.wechat.client.dto.request.SignatureRequest;
import com.shopoo.common.wechat.api.JsapiTicketFacade;
import com.shopoo.common.wechat.api.TokenFacade;
import com.shopoo.common.wechat.dto.clientobject.OpenInfoCO;
import com.shopoo.common.wechat.dto.clientobject.SignatureCO;
import com.shopoo.common.wechat.dto.clientobject.TokenInfoCO;
import com.shopoo.common.wechat.dto.cqe.SecCheckQry;
import com.shopoo.common.wechat.dto.cqe.SignatureQry;
import com.shopoo.common.wechat.dto.cqe.TokenQry;
import com.shopoo.common.wechat.dto.cqe.WechatInfoQry;
import com.szmengran.cola.dto.Response;
import com.szmengran.cola.dto.SingleResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @description 微信开放接口
 * @package com.szmengran.wechat.contronller 
 * @date Sep 25, 2019 11:45:24 AM 
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/wechat")
public class WechatController {
    
    @Autowired
    @Qualifier("wechatTokenService")
    private TokenFacade tokenFacade;
    
    @Autowired
    private JsapiTicketFacade jsapiTicketFacade;
    
    /**
     * 检查一段文本是否含有违法违规内容
     * @Date: 2022/3/14 10:09 PM
     * @Author: Joe
     *
     * @param appId
     * @param appSecret
     * @param msgSecCheckRequest
     * @return com.shopoo.dto.Response
     */
    @PostMapping(value="/msgSecCheck/{appId}/{appSecret}")
    public Response msgSecCheck(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @RequestBody MsgSecCheckRequest msgSecCheckRequest) throws Exception {
        SecCheckQry secCheckQry = SecCheckQry.builder().appId(appId).appSecret(appSecret).content(msgSecCheckRequest.getContent()).build();
        return jsapiTicketFacade.msgSecCheck(secCheckQry);
    }
    
    /**
     * 获取token
     * @Date: 2022/3/14 10:09 PM
     * @Author: Joe
     *
     * @param appId
     * @param appSecret
     * @param code
     * @return com.shopoo.dto.SingleResponse<com.shopoo.wechat.dto.clientobject.TokenInfoCO>
     */
    @GetMapping(value="/token/{appId}/{appSecret}/{code}")
    public SingleResponse<TokenInfoCO> getToken(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @PathVariable("code") String code) throws Exception{
        TokenQry tokenQry = TokenQry.builder().appId(appId).appSecret(appSecret).code(code).build();
        return tokenFacade.getToken(tokenQry);
    }
    
    /**
     * 获取snsapi_userinfo授权的用户开放信息
     * @Date: 2022/3/14 10:09 PM
     * @Author: Joe
     *
     * @param appId
     * @param appSecret
     * @param code
     * @return com.shopoo.wechat.infrastructure.client.dto.response.OpenInfo
     */
    @GetMapping(value="/openinfo/{appId}/{appSecret}/{code}")
    public OpenInfoCO getUserInfo(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @PathVariable("code") String code) throws Exception {
        WechatInfoQry wechatInfoQry = WechatInfoQry.builder().appId(appId).appSecret(appSecret).code(code).build();
        return tokenFacade.getUserInfo(wechatInfoQry).getData();
    }
    
    /**
     * 获取snsapi_base授权的用户信息
     * @Date: 2022/3/14 10:09 PM
     * @Author: Joe
     *
     * @param appId
     * @param appSecret
     * @param code
     * @return com.shopoo.wechat.infrastructure.client.dto.response.OpenInfo
     */
    @GetMapping(value="/baseinfo/{appId}/{appSecret}/{code}")
    public OpenInfoCO getBaseInfo(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @PathVariable("code") String code) throws Exception {
        WechatInfoQry wechatInfoQry = WechatInfoQry.builder().appId(appId).appSecret(appSecret).code(code).build();
        return tokenFacade.getBaseInfo(wechatInfoQry).getData();
    }
    
    /**
     * 获取签名信息
     * @Date: 2022/3/14 10:09 PM
     * @Author: Joe
     * 
     * @param appId
     * @param appSecret
     * @param signatureRequest
     * @return com.shopoo.wechat.infrastructure.client.dto.response.SignatureResponse
     */ 
    @PostMapping("signature/{appId}/{appSecret}")
    public SignatureCO getSignature(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @RequestBody SignatureRequest signatureRequest) {
        SignatureQry signatureQry = SignatureQry.builder().appId(appId).appSecret(appSecret).url(signatureRequest.getUrl()).build();
        return jsapiTicketFacade.getSignature(signatureQry).getData();
    }
}
