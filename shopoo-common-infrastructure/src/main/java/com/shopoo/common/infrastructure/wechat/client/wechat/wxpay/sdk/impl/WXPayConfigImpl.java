package com.shopoo.common.infrastructure.wechat.client.wechat.wxpay.sdk.impl;

import java.io.InputStream;

import com.shopoo.common.infrastructure.wechat.client.wechat.wxpay.sdk.IWXPayDomain;
import com.shopoo.common.infrastructure.wechat.client.wechat.wxpay.sdk.WXPayConfig;

/**
 * @Package com.szmengran.account.wxpay
 * @Description: 支付配置
 * @date Nov 3, 2018 12:02:24 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class WXPayConfigImpl extends WXPayConfig {
    
    private String appID;
    private String mch_id;
    private String key;
    
    public WXPayConfigImpl(String appID, String mch_id, String key) {
        super();
        this.appID = appID;
        this.mch_id = mch_id;
        this.key = key;
    }

    @Override
    public String getAppID() {
        return appID;
    }

    @Override
    public String getMchID() {
        return mch_id;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public InputStream getCertStream() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        // TODO Auto-generated method stub
        return new WXPayDomainImpl();
    }
}
