package com.bwei.wsq.mvpdl.net;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public class URL_API {
    public static final String BASE_URL = "https://www.zhaoapi.cn/";
    //登录
    public static final String LOGIN_URL = "user/login";
    //注册
    public static final String REGISTER_URL = "user/reg";
    //首页列表
    public  static final  String URL="ad/getAd";
    //详情
    public  static final  String XQURL="product/getProductDetail";

    //查询购物车
    public static final String SELECTCAR_PATH_URL = "product/getCarts?source=android";
    //删除购物车（新增）
    public static final String DELETECAR_PATH_URL = "product/deleteCart?source=android";

}
