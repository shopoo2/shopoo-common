package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;

/**
 * @Package com.szmengran.wechat.entity.mini
 * @Description: 图片消息
 * @date Jan 9, 2019 9:44:55 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class ImageRequestBody extends AbstractRequestBody {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
