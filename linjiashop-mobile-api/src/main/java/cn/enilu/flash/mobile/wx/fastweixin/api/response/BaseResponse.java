package cn.enilu.flash.mobile.wx.fastweixin.api.response;


import cn.enilu.flash.mobile.wx.fastweixin.api.entity.BaseModel;
import cn.enilu.flash.mobile.wx.fastweixin.api.enums.ResultType;
import cn.enilu.flash.mobile.wx.fastweixin.util.StrUtil;

/**
 * 微信API响应报文对象基类
 *
 * @author peiyu
 */
public class BaseResponse extends BaseModel {

    private String errcode;
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        //将接口返回的错误信息转换成中文，方便提示用户出错原因
        if (StrUtil.isNotBlank(this.errcode) && !ResultType.SUCCESS.getCode().toString().equals(this.errcode)) {
            return ResultType.get(this.errcode).getDescription();
        }
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
