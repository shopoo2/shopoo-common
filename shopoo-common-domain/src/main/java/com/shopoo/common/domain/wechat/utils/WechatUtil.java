package com.shopoo.common.domain.wechat.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

import com.szmengran.cola.exception.BizException;
import lombok.extern.slf4j.Slf4j;

/** 
 * @Description: 微信操作工具了
 * @Package com.szmengran.wechat.utils 
 * @CreateTime Mar 27, 2019 10:40:09 PM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Slf4j
public class WechatUtil {
    
    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random RANDOM = new SecureRandom();
    
    /**
     * 获取随机字符串 Nonce Str
     *
     * @return String 随机字符串
     */
    public static String generateNonceStr() {
        char[] nonceChars = new char[32];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
    

    /**
     * 获取微信config的签名
     * @param noncestr
     * @param jsapi_ticket
     * @param timestamp
     * @param url
     * @return
     * @throws Exception
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    public static String getSHA1(String noncestr, String jsapi_ticket, String timestamp, String url)
    {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("jsapi_ticket=").append(jsapi_ticket)
              .append("&noncestr=").append(noncestr)
              .append("&timestamp=").append(timestamp)
              .append("&url=").append(url);
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            
            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            log.error("获取微信config的签名:", e);
            throw new BizException(e.getMessage());
        }
    }
}
