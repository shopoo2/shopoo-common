package com.shopoo.common.wechat.mobile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.shopoo.dto.Response;
import com.shopoo.dto.SingleResponse;
import com.shopoo.common.wechat.api.TokenService;
import com.shopoo.common.wechat.api.WechatService;
import com.shopoo.common.wechat.dto.clientobject.LoginInfoCO;
import com.shopoo.common.wechat.dto.clientobject.MiniAppTokenInfoCO;
import com.shopoo.common.wechat.dto.cqe.LoginCmd;
import com.shopoo.common.wechat.dto.cqe.MiniAppTokenQry;
import com.shopoo.common.wechat.dto.cqe.SignatureCheckCmd;
import com.shopoo.common.wechat.dto.cqe.mini.ImageRequest;
import com.shopoo.common.wechat.dto.cqe.mini.LinkRequest;
import com.shopoo.common.wechat.dto.cqe.mini.MiniProgramPageRequest;
import com.shopoo.common.wechat.dto.cqe.mini.TextRequest;
import com.shopoo.common.wechat.dto.cqe.mini.UniformMessageRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @Description: 微信小程序获取用户登录信息
 * @Package com.szmengran.wechat.contronller 
 * @CreateTime Mar 22, 2019 9:37:22 AM 
 * @Author <a href="mailto:android_li@sina.cn">Joe</a> 
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/wechat")
public class WechatMiniAppController {
    
    private static final ExecutorService executor = new ThreadPoolExecutor(2, 100, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//
//    @Autowired
//    private WechatClient wechatClient;

    @Resource
    private WechatService wechatService;

    @Resource
    private TokenService tokenService;
    
    @PostMapping(value="/message/{appId}/{appSecret}")
    public Response sendCustomerMessage(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @RequestBody LinkRequest linkRequest) {
        linkRequest.setAppId(appId);
        linkRequest.setAppSecret(appSecret);
        return wechatService.sendLinkMessage(linkRequest);
    }
    
    /**
     * 发送文本消息
     * @param appId
     * @param appSecret
     * @param textRequest
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @PostMapping(value="/text/{appId}/{appSecret}")
    public Response sendText(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret,
            @RequestBody TextRequest textRequest) {
        textRequest.setAppId(appId);
        textRequest.setAppSecret(appSecret);
        return wechatService.sendTextMessage(textRequest);
    }
    
    /**
     * 发送图片消息
     * @param appId
     * @param appSecret
     * @param imageRequest
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @PostMapping(value="/image/{appId}/{appSecret}")
    public Response sendImage(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret,
            @RequestBody ImageRequest imageRequest) {
        imageRequest.setAppId(appId);
        imageRequest.setAppSecret(appSecret);
        return wechatService.sendImage(imageRequest);
    }
    
    /**
     * 发送图片链接消息
     * @param appId
     * @param appSecret
     * @param linkRequest
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @PostMapping(value="/link/{appId}/{appSecret}")
    public Response sendLink(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret,
            @RequestBody LinkRequest linkRequest) {
        linkRequest.setAppId(appId);
        linkRequest.setAppSecret(appSecret);
        return wechatService.sendLinkMessage(linkRequest);
    }
    
    /**
     * 发送小程序卡片
     * @param miniProgramPageRequest
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @PostMapping(value="/miniprogrampage/{appId}/{appSecret}")
    public Response sendMiniProgramPage(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @RequestBody MiniProgramPageRequest miniProgramPageRequest) {
        miniProgramPageRequest.setAppId(appId);
        miniProgramPageRequest.setAppSecret(appSecret);
        return wechatService.sendMiniProgramPage(miniProgramPageRequest);
    }
    
    @PostMapping(value="/uniformMessage/{appId}/{appSecret}")
    public Response sendUniformMessageRequest(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @RequestBody UniformMessageRequest uniformMessageRequest) {
        uniformMessageRequest.setAppId(appId);
        uniformMessageRequest.setAppSecret(appSecret);
        return wechatService.sendUniformMessage(uniformMessageRequest);
    }
    
    @GetMapping(value = "/signature/{myToken}/{encodingAESKey}/{appId}")
    public SingleResponse<String> checkSignature(@PathVariable("myToken") String myToken, @PathVariable("encodingAESKey") String encodingAESKey, @PathVariable("appId") String appId, HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        SignatureCheckCmd signatureCheckCmd = SignatureCheckCmd
                .builder()
                .signature(signature)
                .timestamp(timestamp)
                .nonce(nonce)
                .echostr(echostr)
                .myToken(myToken)
                .encodingAESKey(encodingAESKey)
                .appId(appId)
                .build();
        return wechatService.checkSignature(signatureCheckCmd);
    }
    
    /**
     * 微信小程序登录信息
     * @param appId
     * @param appSecret
     * @param code
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @GetMapping(value="/sns/jscode2session/{appId}/{appSecret}/{code}")
    LoginInfoCO getLoginInfo(@PathVariable("appId") String appId, @PathVariable("appSecret") String appSecret, @PathVariable("code") String code) {
        LoginCmd loginCmd = LoginCmd.builder().appId(appId).appSecret(appSecret).code(code).build();
        return wechatService.getLoginInfo(loginCmd).getData();
    }
    
    /**
     * 
     * @description 获取小程序token
     * @param appId
     * @param secret
     * @return
     * @date Jan 15, 2020 10:58:27 AM
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    @GetMapping("/cgi-bin/token/{appId}/{secret}")
    MiniAppTokenInfoCO getMiniAppToken(@PathVariable("appId") String appId, @PathVariable("secret") String secret) {
        MiniAppTokenQry miniAppTokenQry = new MiniAppTokenQry(appId, secret);
        return tokenService.getMiniAppToken(miniAppTokenQry).getData();
    }
}
