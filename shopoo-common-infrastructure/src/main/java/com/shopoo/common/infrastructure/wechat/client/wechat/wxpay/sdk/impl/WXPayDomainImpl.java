package com.shopoo.common.infrastructure.wechat.client.wechat.wxpay.sdk.impl;

import com.shopoo.common.infrastructure.wechat.client.wechat.wxpay.sdk.IWXPayDomain;
import com.shopoo.common.infrastructure.wechat.client.wechat.wxpay.sdk.WXPayConfig;
import com.shopoo.common.infrastructure.wechat.client.wechat.wxpay.sdk.WXPayConstants;

/**
 * @Package com.szmengran.account.wxpay
 * @Description: TODO
 * @date Nov 3, 2018 3:43:00 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class WXPayDomainImpl implements IWXPayDomain {

    @Override
    public void report(String domain, long elapsedTimeMillis, Exception ex) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public DomainInfo getDomain(WXPayConfig config) {
        
        return new DomainInfo(WXPayConstants.DOMAIN_API, true);
    }

}
