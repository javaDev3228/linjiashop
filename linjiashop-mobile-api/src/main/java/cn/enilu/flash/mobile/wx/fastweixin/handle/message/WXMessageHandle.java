package cn.enilu.flash.mobile.wx.fastweixin.handle.message;

import cn.enilu.flash.mobile.wx.fastweixin.handle.MessageHandle;
import cn.enilu.flash.mobile.wx.fastweixin.message.BaseMsg;
import cn.enilu.flash.mobile.wx.fastweixin.message.req.BaseReqMsg;

/**
 * 微信消息处理器
 * 
 * @author vill
 *
 */
public class WXMessageHandle<M extends BaseReqMsg> implements MessageHandle<M> {

	@Override
	public BaseMsg handle(M message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean beforeHandle(M message) {
		// TODO Auto-generated method stub
		return false;
	}

}
