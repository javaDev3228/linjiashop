package cn.enilu.flash.mobile.wx.fastweixin.handle.event;


import cn.enilu.flash.mobile.wx.fastweixin.handle.EventHandle;
import cn.enilu.flash.mobile.wx.fastweixin.message.BaseMsg;
import cn.enilu.flash.mobile.wx.fastweixin.message.req.BaseEvent;

/**
 * 微信关注事件处理
 * @author vill
 *
 */
public class WXSubscribeEventHandle implements EventHandle<BaseEvent> {

	@Override
	public BaseMsg handle(BaseEvent event) {
//		NewsMsg newsMsg = new NewsMsg();
//		newsMsg.setToUserName(event.getFromUserName());
//		newsMsg.setFromUserName(event.getToUserName());
//		newsMsg.setMsgType(RespType.NEWS);
//		newsMsg.add();
		return null;
	}

	@Override
	public boolean beforeHandle(BaseEvent event) {
		if(event.getEvent().equals("subscribe")){
			return true;
		}
		return false;
	}

}
