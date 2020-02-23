package cn.enilu.flash.mobile.wx.fastweixin.api.response;

import java.util.List;

import cn.enilu.flash.mobile.wx.fastweixin.api.entity.InterfaceSummaryHour;

/**
 * @author peiyu
 */
public class GetInterfaceSummaryHourResponse extends BaseResponse {

    private List<InterfaceSummaryHour> list;

    public List<InterfaceSummaryHour> getList() {
        return list;
    }

    public void setList(List<InterfaceSummaryHour> list) {
        this.list = list;
    }
}
