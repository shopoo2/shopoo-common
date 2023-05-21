package com.shopoo.common.sms.dto.cqe;

import java.time.LocalDateTime;

import com.szmengran.cola.dto.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.szmengran.common.entity
 * @Description: 短信验证码表
 * @date 2018年4月19日 下午4:25:05
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CaptchaUpdateCmd extends Command {
    
    private String phone;
    private String captcha;
    private LocalDateTime updatestamp;
}
