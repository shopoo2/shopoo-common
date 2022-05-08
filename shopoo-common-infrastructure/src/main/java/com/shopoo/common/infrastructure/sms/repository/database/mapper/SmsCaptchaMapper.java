package com.shopoo.common.infrastructure.sms.repository.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shopoo.common.infrastructure.sms.repository.database.dataobject.TCommonSmsCaptcha;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Package com.szmengran.sms.mapper
 * @Description: TODO
 * @date Jan 10, 2019 8:25:24 AM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Mapper
public interface SmsCaptchaMapper extends BaseMapper<TCommonSmsCaptcha> {

}
