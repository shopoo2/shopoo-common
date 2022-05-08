package com.shopoo.common.app.wechat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.shopoo.common.app.wechat.converter.AppConverter;
import com.shopoo.common.domain.wechat.repository.WechatRepository;
import com.shopoo.common.domain.wechat.utils.aes.WXBizMsgCrypt;
import com.shopoo.common.domain.wechat.valueobject.MiniAppToken;
import com.shopoo.common.infrastructure.wechat.client.WechatClient;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.ImageRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.LinkRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.MiniProgramPageRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.Text;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.TextRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.UniformMessageRequestBody;
import com.shopoo.common.infrastructure.wechat.client.dto.request.mini.MsgResponse;
import com.shopoo.dto.Response;
import com.shopoo.dto.SingleResponse;
import com.shopoo.exception.SysException;
import com.shopoo.common.wechat.api.WechatService;
import com.shopoo.common.wechat.dto.clientobject.LoginInfoCO;
import com.shopoo.common.wechat.dto.clientobject.WechatRegisterCO;
import com.shopoo.common.wechat.dto.cqe.LoginCmd;
import com.shopoo.common.wechat.dto.cqe.SignatureCheckCmd;
import com.shopoo.common.wechat.dto.cqe.WechatRegisterCmd;
import com.shopoo.common.wechat.dto.cqe.mini.ImageRequest;
import com.shopoo.common.wechat.dto.cqe.mini.LinkRequest;
import com.shopoo.common.wechat.dto.cqe.mini.MiniProgramPageRequest;
import com.shopoo.common.wechat.dto.cqe.mini.TextRequest;
import com.shopoo.common.wechat.dto.cqe.mini.UniformMessageRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/26 1:41 PM
 */
@Slf4j
@DubboService
public class WechatServiceImpl implements WechatService {

	private static final ExecutorService executor = new ThreadPoolExecutor(2, 100, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

	@Autowired
	private WechatClient wechatClient;

	@Autowired
	private WechatRepository wechatRepository;

	@Override
	public WechatRegisterCO getWechatRegisterInfo(WechatRegisterCmd wechatRegisterCmd) {
		return null;
	}

	@Override
	public Response sendLinkMessage(LinkRequest linkRequest) {
		log.debug("{}", new Gson().toJson(linkRequest));
		MiniAppToken tokenInfo = wechatRepository.getMiniAppToken(linkRequest.getAppId(), linkRequest.getAppSecret());
		executor.submit(() -> {
			TextRequestBody textRequestBody = new TextRequestBody();
			BeanUtils.copyProperties(linkRequest, textRequestBody);
			textRequestBody.setMsgtype("text");
			Text text = new Text("打开链接然后分享");
			textRequestBody.setText(text);
			com.shopoo.common.infrastructure.wechat.client.dto.request.mini.MsgResponse result1;
			try {
				result1 = wechatClient.sendCustomerMessage(tokenInfo.getAccess_token(), textRequestBody);
				if (result1.getErrcode() == 0) {
					log.debug("{}", new Gson().toJson(result1));
				} else {
					log.error("发送消息失败：{}", new Gson().toJson(result1));
				}
			} catch (Exception e) {
				log.error("发送消息失败：{}", e);
			}
		});
		LinkRequestBody linkRequestBody = AppConverter.INSTANCE.toLinkRequestBody(linkRequest);
		MsgResponse result = wechatClient.sendCustomerMessage(tokenInfo.getAccess_token(), linkRequestBody);
		if (result.getErrcode() != 0) {
			throw new SysException(result.getErrcode().toString(), result.getErrmsg());
		}
		return Response.buildSuccess();
	}

	@Override
	public Response sendTextMessage(TextRequest textRequest) {
		MiniAppToken tokenInfo = wechatRepository.getMiniAppToken(textRequest.getAppId(), textRequest.getAppSecret());
		TextRequestBody textRequestBody = AppConverter.INSTANCE.toTextRequestBody(textRequest);
		MsgResponse result = wechatClient.sendCustomerMessage(tokenInfo.getAccess_token(), textRequestBody);
		if (result.getErrcode() != 0) {
			throw new SysException(result.getErrcode().toString(), result.getErrmsg());
		}
		return Response.buildSuccess();
	}

	@Override
	public Response sendImage(ImageRequest imageRequest) {
		MiniAppToken tokenInfo = wechatRepository.getMiniAppToken(imageRequest.getAppId(), imageRequest.getAppSecret());
		ImageRequestBody imageRequestBody = AppConverter.INSTANCE.toImageRequestBody(imageRequest);
		MsgResponse result = wechatClient.sendCustomerMessage(tokenInfo.getAccess_token(), imageRequestBody);
		if (result.getErrcode() != 0) {
			throw new SysException(result.getErrcode().toString(), result.getErrmsg());
		}
		return Response.buildSuccess();
	}

	@Override
	public Response sendMiniProgramPage(MiniProgramPageRequest miniProgramPageRequest) {
		MiniAppToken tokenInfo = wechatRepository.getMiniAppToken(miniProgramPageRequest.getAppId(), miniProgramPageRequest.getAppSecret());
		MiniProgramPageRequestBody miniProgramPageRequestBody = AppConverter.INSTANCE.toMiniProgramPageRequestBody(miniProgramPageRequest);
		MsgResponse result = wechatClient.sendCustomerMessage(tokenInfo.getAccess_token(), miniProgramPageRequestBody);
		if (result.getErrcode() != 0) {
			throw new SysException(result.getErrcode().toString(), result.getErrmsg());
		}
		return Response.buildSuccess();
	}

	@Override
	public Response sendUniformMessage(UniformMessageRequest uniformMessageRequest) {
		MiniAppToken tokenInfo = wechatRepository.getMiniAppToken(uniformMessageRequest.getAppId(), uniformMessageRequest.getAppSecret());
		UniformMessageRequestBody uniformMessageRequestBody = AppConverter.INSTANCE.toUniformMessageRequestBody(uniformMessageRequest);
		MsgResponse result = wechatClient.sendUniformMessage(tokenInfo.getAccess_token(), uniformMessageRequestBody);
		if (result.getErrcode() != 0) {
			throw new SysException(result.getErrcode().toString(), result.getErrmsg());
		}
		return Response.buildSuccess();
	}

	@Override
	public SingleResponse<LoginInfoCO> getLoginInfo(LoginCmd loginCmd) {
		log.info("用户登录请求：{}", new Gson().toJson(loginCmd));
		String json = wechatClient.getLoginInfo(loginCmd.getAppId(), loginCmd.getAppSecret(), loginCmd.getCode());
		log.info("用户登录结果：{}", json);
		LoginInfoCO loginInfoCO = new Gson().fromJson(json, LoginInfoCO.class);
		if (null != loginInfoCO && loginInfoCO.getErrcode() != null) {
			throw new SysException(loginInfoCO.getErrcode().toString(), loginInfoCO.getErrmsg());
		}
		return SingleResponse.of(loginInfoCO);
	}

	@Override
	public SingleResponse<String> checkSignature(SignatureCheckCmd signatureCheckCmd) {
		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(signatureCheckCmd.getMyToken(), signatureCheckCmd.getEncodingAESKey(), signatureCheckCmd.getAppId());
		String signature = wxBizMsgCrypt.verifyUrl(signatureCheckCmd.getSignature(), signatureCheckCmd.getTimestamp(), signatureCheckCmd.getNonce(), signatureCheckCmd.getEchostr());
		return SingleResponse.of(signature);
	}
}
