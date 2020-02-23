package cn.enilu.flash.mobile.wx.controller;

import cn.enilu.flash.mobile.wx.fastweixin.api.MenuAPI;
import cn.enilu.flash.mobile.wx.fastweixin.api.config.ApiConfig;
import cn.enilu.flash.mobile.wx.fastweixin.api.entity.Menu;
import cn.enilu.flash.mobile.wx.fastweixin.api.entity.MenuButton;
import cn.enilu.flash.mobile.wx.fastweixin.api.enums.MenuType;

import java.util.ArrayList;
import java.util.List;

public class TestMenuApi {

    private static final String appid = "wxc8555a3f0af985d5";
    private static final String secret = "f9a06ecfc510eaac2c3698157c35a4c3";
    private static final String token = "TOKEN";
    private static final boolean encryptMessage = false;
    private static final String encodingAESKey = "4nuEBb55GZs7NZvoa2owPYEa3hSpRST79Kcj7efzCIJ";

    public static void initMenu() {
        System.out.println("初始化微信api");
        ApiConfig config = new ApiConfig(appid, secret, token, encryptMessage, encodingAESKey);
        MenuAPI menuApi = new MenuAPI(config);
        //删除所有菜单
        menuApi.deleteMenu();
        //创建菜单
        Menu menu = new Menu();
        List<MenuButton> buttons = new ArrayList<MenuButton>();
        MenuButton btn1 = new MenuButton();
        btn1.setName("我要买菜");
        btn1.setType(MenuType.VIEW);
        String url1="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc8555a3f0af985d5&redirect_uri=http%3a%2f%2fc9e84d32.ngrok.io%2f&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
        btn1.setUrl(url1);



        buttons.add(btn1);

        menu.setButton(buttons);

        menuApi.createMenu(menu);
        //获取菜单
        menuApi.getMenu();
    }

    public static void main(String[] args) {
        initMenu();
    }
}
