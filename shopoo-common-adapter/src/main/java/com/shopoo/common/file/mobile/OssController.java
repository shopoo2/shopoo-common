package com.shopoo.common.file.mobile;

import java.util.Map;

import com.shopoo.common.file.api.OssService;
import com.shopoo.common.file.dto.cqe.QrCodeRequest;
import com.shopoo.dto.SingleResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @Description: OSS API
 * @Package com.szmengran.aliyun.controller 
 * @CreateTime May 7, 2019 1:07:51 PM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@RestController
public class OssController {

    @Autowired
    private OssService ossService;
    
    @Value("${aliyun.oss.bucket}")
    private String bucket;
    
    @GetMapping("oss/signature")
    public SingleResponse getSignature() throws Exception {
        Map<String, String> map = ossService.getSignature();
        return SingleResponse.of(map);
    }
    
    /**
     * 小程序码上传到OSS
     * @param appid
     * @param secret
     * @param qrCodeRequest
     * @Return com.shopoo.dto.SingleResponse
     * @Date: 2022/5/9 12:26 AM
     * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
     */
    @PostMapping("getwxacodeunlimit/{appid}/{secret}")
    public SingleResponse getwxacodeunlimit(@PathVariable("appid") String appid, @PathVariable("secret") String secret, @RequestBody QrCodeRequest qrCodeRequest) {
        qrCodeRequest.setAppId(appid);
        qrCodeRequest.setAppSecret(secret);
        return ossService.getwxacodeunlimit(qrCodeRequest);
    }
}
