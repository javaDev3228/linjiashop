package cn.enilu.flash.mobile.wx.fastweixin.api.response;


import cn.enilu.flash.mobile.wx.fastweixin.api.entity.UserShare;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUserShareResponse extends BaseResponse {

    private List<UserShare> list;

    public List<UserShare> getList() {
        return list;
    }

    public void setList(List<UserShare> list) {
        this.list = list;
    }
}
