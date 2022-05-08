package com.shopoo.common.file.api;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.shopoo.common.file.dto.cqe.QrCodeRequest;
import com.shopoo.dto.SingleResponse;

/** 
 * @Description: 阿里云OSS服务
 * @Package com.szmengran.file.service 
 * @CreateTime May 7, 2019 10:30:56 AM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
public interface OssService {
    
    /**
     * 文件类型
     * @return 
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    Map<String, String> getSignature() throws UnsupportedEncodingException;
    
    /**
     * 上传文件到OSS
     * @param inputStream
     * @param userid
     * @return
     */
    String uploadToOss(InputStream inputStream, String userid);

    SingleResponse<String> getwxacodeunlimit(QrCodeRequest qrCodeRequest);
}
