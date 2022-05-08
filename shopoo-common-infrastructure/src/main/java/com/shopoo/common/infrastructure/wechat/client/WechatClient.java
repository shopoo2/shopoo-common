package com.shopoo.common.infrastructure.wechat.client;

import com.shopoo.common.infrastructure.wechat.client.dto.request.MsgSecCheckRequest;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.AbstractRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.MsgResponse;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.QrCodeRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.UniformMessageRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.response.JsapiTicketResponse;
import com.shopoo.common.infrastructure.wechat.client.dto.response.MsgSecCheckResponse;
import com.shopoo.common.infrastructure.wechat.client.dto.response.TokenInfo;
import com.shopoo.common.infrastructure.wechat.client.dto.response.mini.MiniAppTokenInfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 
 * @description 对接微信官方接口
 * @package com.szmengran.api.wechat 
 * @date Jan 15, 2020 10:49:51 AM 
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@FeignClient(name = "wechatApi", url = "https://api.weixin.qq.com")
public interface WechatClient {
    
    /**
     * 检查一段文本是否含有违法违规内容
     * @param accessToken
     * @param msgSecCheckRequest
     * @Return com.shopoo.wechat.infrastructure.client.dto.response.MsgSecCheckResponse
     * @Date: 2022/3/20 12:37 AM
     * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
     */
    @PostMapping(value="/wxa/msg_sec_check?access_token={accessToken}")
    MsgSecCheckResponse msgSecCheck(@PathVariable("accessToken") String accessToken, @RequestBody MsgSecCheckRequest msgSecCheckRequest);
    
    /**
     * 获取微信token
     * @param appId
     * @param secret
     * @param code
     * @Return java.lang.String
     * @Date: 2022/3/20 12:37 AM
     * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
     */
    @GetMapping(value="/sns/oauth2/access_token?appid={appId}&secret={secret}&code={code}&grant_type=authorization_code")
    String getToken(@PathVariable("appId") String appId, @PathVariable("secret") String secret, @PathVariable("code") String code);
    
    /**
     * 微信通过授权码获取用户信息
     * @Date: 2022/3/14 5:59 PM
     * @Author: Joe
     *
     * @param accessToken
     * @param openId
     * @return java.lang.String
     */
    @GetMapping(value="/sns/userinfo?access_token={accessToken}&openid={openId}OPENID&lang=zh_CN", headers="Content-Type=application/json;charset=utf-8", consumes="application/json; charset=UTF-8")
    String getOpenInfo(@PathVariable("accessToken") String accessToken, @PathVariable("openId") String openId);
    
    /**
     * 获取jsapi_ticket
     * @Date: 2022/3/14 6:02 PM
     * @Author: Joe
     * 
     * @param accessToken
     * @return JsapiTicketResponse
     */ 
    @GetMapping("/cgi-bin/ticket/getticket?access_token={accessToken}&type=jsapi")
    JsapiTicketResponse getJsapiTicker(@PathVariable("accessToken") String accessToken);
    
    /**
     * 获取平台Api调用的token
     * @param appId
     * @param secret
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @GetMapping("/cgi-bin/token?grant_type=client_credential&appid={appId}&secret={secret}")
    TokenInfo getApiToken(@PathVariable("appId") String appId, @PathVariable("secret") String secret);
    
    /**
     * 
     * @description 获取小程序码
     * @param accessToken
     * @param qrCodeRequestBody
     * @return
     * @date Jan 15, 2020 9:46:50 AM
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @PostMapping("/wxa/getwxacodeunlimit?access_token={accessToken}")
    Object getwxacodeunlimit(@PathVariable("accessToken") String accessToken, @RequestBody QrCodeRequestBody qrCodeRequestBody);
    
    /**
     * 微信小程序消息发送api
     * @param accessToken
     * @param abstractRequestBody
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @PostMapping("/cgi-bin/message/custom/send?access_token={accessToken}")
    MsgResponse sendCustomerMessage(@PathVariable("accessToken") String accessToken,
            @RequestBody AbstractRequestBody abstractRequestBody);

    /**
     * 微信小程序消息发送api
     * @param accessToken
     * @param uniformMessageRequestBody
     * @return
     * @throws Exception 
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @PostMapping("/cgi-bin/message/wxopen/template/uniform_send?access_token={accessToken}")
    MsgResponse sendUniformMessage(@PathVariable("accessToken") String accessToken,
            @RequestBody UniformMessageRequestBody uniformMessageRequestBody);
    
    /**
     * 获取微信小程序token
     * @param appId
     * @param secret
     * @return
     * @throws Exception 
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @GetMapping("/cgi-bin/token?grant_type=client_credential&appid={appId}&secret={secret}")
    MiniAppTokenInfo getMiniAppToken(@PathVariable("appId") String appId, @PathVariable("secret") String secret);
    
    /**
     * 微信小程序登录信息
     * @param appId
     * @param appSecret
     * @param code
     * @return
     * @throws Exception 
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @GetMapping(value="/sns/jscode2session?appid={appId}&secret={appSecret}&js_code={code}&grant_type=authorization_code", headers="Content-Type=application/json;charset=utf-8" , produces = "application/json; charset=UTF-8")
    String getLoginInfo(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @PathVariable("code") String code);
    
}
