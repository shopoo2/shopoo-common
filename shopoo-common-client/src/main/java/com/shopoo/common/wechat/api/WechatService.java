package com.shopoo.common.wechat.api;

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
import com.shopoo.dto.Response;
import com.shopoo.dto.SingleResponse;

public interface WechatService {

	/**
	 * 获取微信注册信息
	 * @param wechatRegisterCmd
	 * @Return com.shopoo.wechat.dto.clientobject.WechatRegisterCO
	 * @Date: 2022/3/20 11:18 AM
	 * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
	 */ 
	WechatRegisterCO getWechatRegisterInfo(WechatRegisterCmd wechatRegisterCmd);

	/**
	 * 发送链接消息
	 * @param linkRequest
	 * @Return com.shopoo.dto.Response
	 * @Date: 2022/3/26 2:13 PM
	 * @Author: <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
	 */ 
	Response sendLinkMessage(LinkRequest linkRequest);

	Response sendTextMessage(TextRequest textRequest);

	Response sendImage(ImageRequest imageRequest);

	Response sendMiniProgramPage(MiniProgramPageRequest miniprogrampageRequest);

	Response sendUniformMessage(UniformMessageRequest uniformMessageRequest);
	SingleResponse<LoginInfoCO> getLoginInfo(LoginCmd loginCmd);

	SingleResponse<String> checkSignature(SignatureCheckCmd signatureCheckCmd);

}
