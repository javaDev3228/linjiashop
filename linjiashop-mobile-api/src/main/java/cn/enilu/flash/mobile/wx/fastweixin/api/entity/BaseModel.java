package cn.enilu.flash.mobile.wx.fastweixin.api.entity;


import cn.enilu.flash.mobile.wx.fastweixin.util.JSONUtil;

/**
 * 抽象实体类
 *
 * @author peiyu
 */
public abstract class BaseModel implements Model {
    @Override
    public String toJsonString() {
        return JSONUtil.toJson(this);
    }
}
