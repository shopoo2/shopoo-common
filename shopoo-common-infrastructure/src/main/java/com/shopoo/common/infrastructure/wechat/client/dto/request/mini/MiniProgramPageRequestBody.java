package com.shopoo.common.infrastructure.wechat.client.dto.request.mini;

/**
 * @Package com.szmengran.wechat.entity.mini
 * @Description: 小程序卡片
 * @date Jan 9, 2019 9:44:55 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
public class MiniProgramPageRequestBody extends AbstractRequestBody {
    private Miniprogrampage miniprogrampage;

    public Miniprogrampage getMiniprogrampage() {
        return miniprogrampage;
    }

    public void setMiniprogrampage(Miniprogrampage miniprogrampage) {
        this.miniprogrampage = miniprogrampage;
    }
    
}
