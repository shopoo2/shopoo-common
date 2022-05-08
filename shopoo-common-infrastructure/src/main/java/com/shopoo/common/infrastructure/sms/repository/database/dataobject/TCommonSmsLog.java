package com.shopoo.common.infrastructure.sms.repository.database.dataobject;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Package com.szmengran.common.entity
 * @Description: 短信日志信息
 * @date 2018年4月6日 下午3:01:19
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Data
public class TCommonSmsLog {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private String signname;
    private String templatecode;
    private String templateparam;
    private String outid;
    private String result;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createstamp;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatestamp;
}
