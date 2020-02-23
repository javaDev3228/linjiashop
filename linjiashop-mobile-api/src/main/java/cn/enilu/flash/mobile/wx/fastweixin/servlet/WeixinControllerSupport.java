package cn.enilu.flash.mobile.wx.fastweixin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.http.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 微信公众平台交互操作基类，提供几乎所有微信公众平台交互方式
 * 基于springmvc框架，方便使用此框架的项目集成
 *
 * @author peiyu
 */
@Controller
public abstract class WeixinControllerSupport extends WeixinSupport {
	
	private Logger log = LoggerFactory.getLogger(WeixinControllerSupport.class);
	
    /**
     * 绑定微信服务器
     *
     * @param request 请求
     * @return 响应内容
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    protected  void bind(HttpServletRequest request, HttpServletResponse response) {
        if (isLegal(request)) {
            //绑定微信服务器成功
            //return request.getParameter("echostr");
            super.bindServer(request,response);

        }
    }

    /**
     * 微信消息交互处理
     *
     * @param request http 请求对象
     * @return 响应给微信服务器的消息报文
     * @throws ServletException 异常
     * @throws IOException      IO异常
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    protected final String process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	log.debug("微信消息接入，开始验证签名", request.getQueryString());
        if (!isLegal(request)) {
        	log.debug("微信消息接入，验证签名失败", request.getQueryString());
        }
        log.debug("微信消息接入，验证签名成功", request.getQueryString());
        String result=  processRequest(request,response);
        return result;
    }
}