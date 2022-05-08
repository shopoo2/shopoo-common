package com.shopoo.common.app.file.converter;

import com.shopoo.common.file.dto.cqe.ImageAddCmd;
import com.shopoo.common.file.dto.cqe.QrCodeRequest;
import com.shopoo.common.infrastructure.file.client.dto.QrCodeRequestBody;
import com.shopoo.common.infrastructure.file.repository.database.dataobject.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @Author <a href="mailto:android_li@sina.cn">MaoYuan.Li</a>
 * @Date 2022/3/26 4:31 PM
 */
@Mapper
public interface AppConverter {

	AppConverter INSTANCE = Mappers.getMapper(AppConverter.class);

	Image toImage(ImageAddCmd imageAddCmd);

	QrCodeRequestBody toQrCodeRequestBody(QrCodeRequest qrCodeRequest);
}
