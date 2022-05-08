package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;
/**
 * @Package com.szmengran.wechat.entity
 * @Description: TODO
 * @date Nov 20, 2018 10:06:50 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class Miniprogrampage {
    private String title;
    private String pagepath;
    private String thumb_media_id;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPagepath() {
        return pagepath;
    }
    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
    public String getThumb_media_id() {
        return thumb_media_id;
    }
    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }
}
