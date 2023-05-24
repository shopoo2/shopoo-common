package com.shopoo.common.app.file;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyun.oss.model.PutObjectRequest;
import com.shopoo.common.app.file.converter.AppConverter;
import com.shopoo.common.domain.file.utils.Contants;
import com.shopoo.common.file.api.OssFacade;
import com.shopoo.common.file.dto.cqe.QrCodeRequest;
import com.shopoo.common.infrastructure.file.client.WechatMiniAppClient;
import com.shopoo.common.infrastructure.file.client.dto.QrCodeRequestBody;
import com.shopoo.common.infrastructure.file.config.AliyunProperties;
import com.shopoo.common.wechat.api.TokenFacade;
import com.shopoo.common.wechat.dto.clientobject.MiniAppTokenInfoCO;
import com.shopoo.common.wechat.dto.cqe.MiniAppTokenQry;
import com.szmengran.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** 
 * @Description: 阿里云OSS服务
 * @Package com.szmengran.file.service.impl 
 * @CreateTime May 7, 2019 10:31:07 AM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Service
@DubboService
public class OssFacadeImpl implements OssFacade {
    
    private final static Integer EXPIRE_TIME = 8 * 60 * 1000; //过期时间为8分钟
    private final static long REDIX_EXPIRE_TIME = 5 * 60 * 1000l; //redis过期时间为5分钟
    private final static Logger logger = LoggerFactory.getLogger(OssFacadeImpl.class);

    @DubboReference
    private TokenFacade tokenFacade;

    @Resource
    private WechatMiniAppClient WechatMiniAppClient;

    @Resource
    private AliyunProperties properties;
    
    @Cacheable(value = "aliyunOss", key = "#p0")
    @Override
    public Map<String, String> getSignature() throws UnsupportedEncodingException {
        OSS ossClient = new OSSClientBuilder().build(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret());
        long expireEndTime = System.currentTimeMillis() + EXPIRE_TIME;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, properties.getMaxFileSize());

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);
        Map<String, String> map = new HashMap<String, String>();
        map.put("host", properties.getHost());
        map.put("policy", encodedPolicy);
        map.put("signature", postSignature);
        map.put("OSSAccessKeyId", properties.getAccessKeyId());
        return map;
    }
    
    @CacheEvict(allEntries = true, value = "aliyunOss")
    @Scheduled(fixedDelay = REDIX_EXPIRE_TIME ,  initialDelay = REDIX_EXPIRE_TIME)
    public void wechatCacheEvict() {
        logger.debug("remove aliyunOss signature");
    }
    
    /**
     * 上传文件到OSS
     * @param inputStream
     * @param userid
     * @return
     */
    public String uploadToOss(InputStream inputStream, String userid) {
    	// 创建OSSClient实例
    	OSS ossClient = new OSSClientBuilder().build(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret());
        //随机生成图片名
        String filePath = Contants.wechatMiniAppFilePath;
        String fileName = userid+".png";
        try {
            //把小程序原始太阳码存入OSS中
            ossClient.putObject(new PutObjectRequest(properties.getBucket(), filePath + fileName, inputStream));
        } catch (Exception e) {
        	logger.error("调用小程序生成微信永久小程序码URL接口异常", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ossClient.shutdown();
        }
        return properties.getHost()+"/"+filePath+fileName;
    }

    @Override
    public SingleResponse<String> getwxacodeunlimit(QrCodeRequest qrCodeRequest) {
        MiniAppTokenQry miniAppTokenQry = MiniAppTokenQry.builder().appId(qrCodeRequest.getAppId()).appSecret(qrCodeRequest.getAppSecret()).build();
        SingleResponse<MiniAppTokenInfoCO> singleResponse = tokenFacade.getMiniAppToken(miniAppTokenQry);
        MiniAppTokenInfoCO miniAppTokenInfoCO = singleResponse.getData();
        QrCodeRequestBody qrCodeRequestBody = AppConverter.INSTANCE.toQrCodeRequestBody(qrCodeRequest);
        byte[] data = WechatMiniAppClient.getwxacodeunlimit(miniAppTokenInfoCO.getAccessToken(), qrCodeRequestBody);
        InputStream inputStream = new ByteArrayInputStream(data);
        String filePath = uploadToOss(inputStream, qrCodeRequestBody.getScene());
        return SingleResponse.of(filePath);
    }
}
