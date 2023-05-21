package com.shopoo.common.wechat.api;

import com.shopoo.common.wechat.dto.clientobject.JsapiTicketCO;
import com.shopoo.common.wechat.dto.clientobject.SignatureCO;
import com.shopoo.common.wechat.dto.cqe.JsapiTicketQry;
import com.shopoo.common.wechat.dto.cqe.SecCheckQry;
import com.shopoo.common.wechat.dto.cqe.SignatureQry;
import com.szmengran.cola.dto.Response;
import com.szmengran.cola.dto.SingleResponse;

/** 
 * @Description: 获取jsapi_ticket服务
 * @Package com.szmengran.wechat.service 
 * @CreateTime Mar 27, 2019 10:19:59 PM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
public interface JsapiTicketFacade {

    /**
     * 获取jsapi_ticket信息
     * @Date: 2022/3/14 6:30 PM
     * @Author: Joe
     * 
     * @param jsapiTicketQry
     * @return com.shopoo.dto.SingleResponse<com.shopoo.wechat.dto.clientobject.JsapiTicketCO>
     */ 
    SingleResponse<JsapiTicketCO> getJsapiTicket(JsapiTicketQry jsapiTicketQry);

    SingleResponse<SignatureCO> getSignature(SignatureQry signatureQry);
    Response msgSecCheck(SecCheckQry secCheckQry);
}
