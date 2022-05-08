package com.shopoo.common.infrastructure.sms.repository.database.dataobject;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Package com.szmengran.common.entity
 * @Description: 短信验证码表
 * @date 2018年4月19日 下午4:25:05
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class TCommonSmsCaptcha {
    
    private String phone;
    private String captcha;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatestamp;
}
