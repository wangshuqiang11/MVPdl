package com.bwei.wsq.mvpdl.model;

import com.bwei.wsq.mvpdl.bean.LoginBean;
import com.bwei.wsq.mvpdl.model.imodel.ILoginModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.net.RetrofitHelper;
import com.bwei.wsq.mvpdl.net.ServiceApi;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import rx.Observable;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public class LoginModel implements ILoginModel{
    @Override
    public void login(String mobile, String password, final OnNetListener<LoginBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        Flowable<LoginBean> login = serviceApi.login(mobile, password);
        login.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {

            }
        }).subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        onNetListener.onSuccess(loginBean);
                    }
                });


    }

}
