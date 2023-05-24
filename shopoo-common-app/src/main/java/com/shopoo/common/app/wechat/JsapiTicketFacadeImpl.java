package com.shopoo.common.app.wechat;

import com.shopoo.common.app.wechat.converter.AppConverter;
import com.shopoo.common.domain.wechat.utils.WechatUtil;
import com.shopoo.common.infrastructure.wechat.client.WechatClient;
import com.shopoo.common.infrastructure.wechat.client.dto.request.MsgSecCheckRequest;
import com.shopoo.common.infrastructure.wechat.client.dto.response.JsapiTicketResponse;
import com.shopoo.common.infrastructure.wechat.client.dto.response.MsgSecCheckResponse;
import com.shopoo.common.infrastructure.wechat.client.dto.response.SignatureResponse;
import com.shopoo.common.infrastructure.wechat.client.dto.response.TokenInfo;
import com.shopoo.common.wechat.api.JsapiTicketFacade;
import com.shopoo.common.wechat.dto.clientobject.JsapiTicketCO;
import com.shopoo.common.wechat.dto.clientobject.SignatureCO;
import com.shopoo.common.wechat.dto.cqe.JsapiTicketQry;
import com.shopoo.common.wechat.dto.cqe.SecCheckQry;
import com.shopoo.common.wechat.dto.cqe.SignatureQry;
import com.szmengran.cola.dto.Response;
import com.szmengran.cola.dto.SingleResponse;
import com.szmengran.cola.exception.BizException;
import com.szmengran.cola.exception.SysException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;

/** 
 * @Description: 获取jsapi_ticket服务
 * @Package com.szmengran.wechat.service.impl 
 * @CreateTime Mar 27, 2019 10:20:18 PM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Slf4j
@DubboService
public class JsapiTicketFacadeImpl implements JsapiTicketFacade {
    
    @Resource
    private WechatClient wechatClient;
    
    @CacheEvict(allEntries = true, value = "jsapi_ticket")
    @Scheduled(fixedDelay = 2 * 45 * 60 * 1000 ,  initialDelay = 2 * 45 * 60 * 1000)
    public void wechatCacheEvict() {
        log.debug("remove wechatToken cache");
    }
    
    @Cacheable(value = "jsapi_ticket", key = "#jsapiTicketQry.appId")
    @Override
    public SingleResponse<JsapiTicketCO> getJsapiTicket(JsapiTicketQry jsapiTicketQry) {
        JsapiTicketResponse jsapiTicketResponse = wechatClient.getJsapiTicker(jsapiTicketQry.getAccessToken());
        if (jsapiTicketResponse.getErrcode() != 0) {
            throw new BizException(jsapiTicketResponse.getErrcode()+"", jsapiTicketResponse.getErrmsg());
        }
        return SingleResponse.of(AppConverter.INSTANCE.toJsapiTicketCO(jsapiTicketResponse));
    }

    @Override
    public SingleResponse<SignatureCO> getSignature(SignatureQry signatureQry) {
        TokenInfo tokenInfo = wechatClient.getApiToken(signatureQry.getAppId(), signatureQry.getAppSecret());
        if (tokenInfo.getErrcode() != null) {
            throw new SysException("获取不到token信息");
        }
        JsapiTicketResponse jsapiTicketResponse = wechatClient.getJsapiTicker(tokenInfo.getAccess_token());
        if (jsapiTicketResponse.getErrcode() != 0) {
            throw new SysException("获取jsapi_ticket失败！");
        }
        String jsapi_ticket = jsapiTicketResponse.getTicket();
        String timestamp = (System.currentTimeMillis()+"").substring(0, 10);
        String noncestr = WechatUtil.generateNonceStr();
        String url = signatureQry.getUrl();
        String signature = WechatUtil.getSHA1(noncestr, jsapi_ticket, timestamp, url);
        SignatureResponse signatureResponse = new SignatureResponse();
        signatureResponse.setAppId(signatureQry.getAppId());
        signatureResponse.setNonceStr(noncestr);
        signatureResponse.setSignature(signature);
        signatureResponse.setTimestamp(timestamp);
        return SingleResponse.of(AppConverter.INSTANCE.toSignatureCO(signatureResponse));
    }

    @Override
    public Response msgSecCheck(SecCheckQry secCheckQry) {
        TokenInfo tokenInfo = wechatClient.getApiToken(secCheckQry.getAppId(), secCheckQry.getAppSecret());
        MsgSecCheckRequest msgSecCheckRequest = new MsgSecCheckRequest();
        msgSecCheckRequest.setContent(secCheckQry.getContent());
        MsgSecCheckResponse msgSecCheckResponse = wechatClient.msgSecCheck(tokenInfo.getAccess_token(), msgSecCheckRequest);
        if (msgSecCheckResponse.getErrcode() == 0) {
            return Response.buildSuccess();
        }
        throw new BizException(msgSecCheckResponse.getErrcode().toString(), msgSecCheckResponse.getErrmsg());
    }
}
