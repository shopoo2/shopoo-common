package com.shopoo.common.file.api;

import com.shopoo.common.file.dto.cqe.ImageAddCmd;

/**
 * @Package com.szmengran.file.service
 * @Description: 文件操作服务
 * @date Feb 21, 2019 6:35:10 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public interface ImageService {

    /**
     * 文件信息保存上传
     * @param images
     * @return
     * @author <a href="mailto:android_li@sina.cn">Joe</a>
     */
    Boolean save(ImageAddCmd[] images);
    
}
