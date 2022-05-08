package com.shopoo.common.infrastructure.wechat.client.wechat.wxpay.sdk;
/**
 * @Package com.szmengran.wxpay.sdk
 * @Description: 微信支付结果处理响应
 * @date Jan 7, 2019 10:19:43 AM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class WXPayResultResponse {
    
    public static String getResponseXml(String flag, String msg) {
        StringBuilder xml = new StringBuilder();
        xml.append("<xml>")
           .append("<return_code>").append(flag).append("</return_code>")
           .append("<return_msg>").append(msg).append("</return_msg>")
           .append("</xml>");
        return xml.toString();
    }
}
