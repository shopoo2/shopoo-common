package com.shopoo.common.sms.dto.cqe;

import com.szmengran.cola.base.annotation.Phone;
import com.szmengran.cola.dto.Command;
import lombok.Data;

/**
 * @Package com.szmengran.common.entity
 * @Description: 短信日志信息
 * @date 2018年4月6日 下午3:01:19
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class CommonSmsSendCmd extends Command {

    @Phone
    private String phone;
    private String signname;
    private String templatecode;
    private String templateparam;
    private String outid;
    private String result;
}
