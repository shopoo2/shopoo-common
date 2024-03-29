package com.shopoo.common.file.mobile;

import com.shopoo.common.file.api.ImageFacade;
import com.shopoo.common.file.dto.cqe.ImageAddCmd;
import com.szmengran.cola.dto.Response;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.szmengran.hbase.controller
 * @Description: 图片处理
 * @date 2018年10月21日 下午9:16:34
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@RestController
public class ImageController {

    @Resource
    private ImageFacade imageFacade;

    @PostMapping(value = "/image")
    @ResponseBody
    public Response save(@RequestBody ImageAddCmd[] images) {
        imageFacade.save(images);
        return Response.buildSuccess();
    }

}
