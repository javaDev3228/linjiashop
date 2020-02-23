package cn.enilu.flash.mobile.wx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.enilu.flash.mobile.wx.fastweixin.servlet.WeixinControllerSupport;
import com.alibaba.druid.support.json.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.enilu.flash.mobile.wx.fastweixin.api.JsAPI;
import cn.enilu.flash.mobile.wx.fastweixin.api.config.ApiConfig;
import cn.enilu.flash.mobile.wx.fastweixin.handle.EventHandle;
import cn.enilu.flash.mobile.wx.fastweixin.handle.MessageHandle;
import cn.enilu.flash.mobile.wx.fastweixin.handle.event.WXEventHandle;
import cn.enilu.flash.mobile.wx.fastweixin.handle.event.WXSubscribeEventHandle;
import cn.enilu.flash.mobile.wx.fastweixin.handle.message.WXMessageHandle;
import cn.enilu.flash.mobile.wx.fastweixin.message.BaseMsg;
import cn.enilu.flash.mobile.wx.fastweixin.message.TextMsg;
import cn.enilu.flash.mobile.wx.fastweixin.message.req.BaseEvent;
import cn.enilu.flash.mobile.wx.fastweixin.message.req.TextReqMsg;

@Controller
@RequestMapping("/wx/bind")
public class WeixinController extends WeixinControllerSupport {

    private static final Logger log = LoggerFactory.getLogger(WeixinController.class);


    private final static  String TOKEN ="TOKEN";

    private final static String APPID ="wxc8555a3f0af985d5";

    private final static String KEY ="f9a06ecfc510eaac2c3698157c35a4c3";


    @Override
    public String getToken() {
        return TOKEN;
    }

    //使用安全模式时设置：APPID
    //不再强制重写，有加密需要时自行重写该方法
    @Override
    protected String getAppId() {
        return APPID;
    }

    @Override
    protected String getAESKey() {
        return KEY;
    }

    /**
     * 根据当前页面请求路径获取签名信息
     *
     * @param reqUrl 请求地址
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/jsapiauth")
    @ResponseBody
    public String getauthz(@RequestParam("localhref") String reqUrl, HttpServletResponse resonse) throws IOException {
        if (reqUrl.contains("&amp;")) {
            reqUrl = reqUrl.replaceAll("\\&amp;", "&");
        }
        ApiConfig apiConfig = new ApiConfig(getAppId(),KEY,TOKEN,false,"");

        JsAPI jsAPI = new JsAPI(apiConfig);
        return renderString(resonse, jsAPI.getSignature(reqUrl));
//      return JsonMapper.toJsonString(jsAPI.getSignature(reqUrl));
    }


//    //重写父类方法，处理对应的微信消息
//    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();
        return new TextMsg("欢迎使用同城电子商务");
    }
//    @Override
//    protected BaseMsg handleMenuClickEvent(MenuEvent event) {
//    	String eventKey =event.getEventKey();
//    	 if(StringUtils.isNotEmpty(eventKey)&&eventKey.equals("appoint_001")){
//    		 Map<String,Object> param = new HashMap<String,Object>();
//    		 param.put("openId", event.getFromUserName());
//    	
//      	   
//          }
//        return handleDefaultEvent(event);
//    }
//    /**
//     * 处理添加关注事件，有需要时子类重写
//     *
//     * @param event 添加关注事件对象
//     * @return 响应消息对象
//     */
    @Override
	protected BaseMsg handleSubscribe(BaseEvent event) {
        return new TextMsg("欢迎使用同城电子商务");

    }
    

    /*1.1版本新增，重写父类方法，加入自定义微信消息处理器
     *不是必须的，上面的方法是统一处理所有的文本消息，如果业务觉复杂，上面的会显得比较乱
     *这个机制就是为了应对这种情况，每个MessageHandle就是一个业务，只处理指定的那部分消息
     */
    @Override
    protected List<MessageHandle> initMessageHandles() {
        List<MessageHandle> handles = new ArrayList<MessageHandle>();
        handles.add(new WXMessageHandle());
        return handles;
    }

    //1.1版本新增，重写父类方法，加入自定义微信事件处理器，同上
    @Override
    protected List<EventHandle> initEventHandles() {
        List<EventHandle> handles = new ArrayList<EventHandle>();
        handles.add(new WXSubscribeEventHandle());
        handles.add(new WXEventHandle());
        return handles;
    }

    @RequestMapping("accessToken")
    public String getAccessToken(HttpServletRequest request) {
        String code = request.getParameter("code");
        return code;
    }

    @RequestMapping("refreshToken")
    public String refreshToken() {
        return null;
    }





    /**
     * 客户端返回字符串
     * @param response
     * @param string
     * @return
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }
    }


    /**
     * 客户端返回JSON字符串
     * @param response
     * @param object
     * @return
     */
    protected String renderString(HttpServletResponse response, Object object) {
        return renderString(response, JSONUtils.toJSONString(object), "application/json");
    }

}
