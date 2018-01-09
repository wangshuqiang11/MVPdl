package com.bwei.wsq.mvpdl.net;

import com.bwei.wsq.mvpdl.bean.BaseBean;
import com.bwei.wsq.mvpdl.bean.CartBean;
import com.bwei.wsq.mvpdl.bean.LoginBean;
import com.bwei.wsq.mvpdl.bean.RegisterBean;
import com.bwei.wsq.mvpdl.bean.ShowBean;
import com.bwei.wsq.mvpdl.bean.XqBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public interface ServiceApi {
    //登录
    @GET(URL_API.LOGIN_URL)
    public Flowable<LoginBean> login(@Query("mobile") String mobile, @Query("password") String password);

    //注册
    @GET(URL_API.REGISTER_URL)
    public Flowable<RegisterBean> register(@Query("mobile") String mobile, @Query("password") String password);

    //详情
    @GET(URL_API.XQURL)
    Flowable<XqBean> xqbean(@Query("pid") String pid , @Query("source") String source);
    //查询购物车
    @GET(URL_API.SELECTCAR_PATH_URL)
    public Flowable<CartBean> getCart(@Query("uid") String uid);

    //删除购物车
    @GET(URL_API.DELETECAR_PATH_URL)
    public Flowable<BaseBean> deleteGoodCar(@Query("uid") String uid, @Query("pid") String pid);
    //列表展示
    @GET(URL_API.URL)
    Flowable<ShowBean> showbean();
}
