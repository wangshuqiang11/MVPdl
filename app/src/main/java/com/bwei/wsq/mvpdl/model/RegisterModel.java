package com.bwei.wsq.mvpdl.model;

import com.bwei.wsq.mvpdl.bean.RegisterBean;
import com.bwei.wsq.mvpdl.model.imodel.IRegisterModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.net.RetrofitHelper;
import com.bwei.wsq.mvpdl.net.ServiceApi;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public class RegisterModel implements IRegisterModel {
    @Override
    public void register(String mobile, String password, final OnNetListener<RegisterBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        Flowable<RegisterBean> register = serviceApi.register(mobile, password);
        register.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {

            }
        })
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean registerBean) throws Exception {
                        onNetListener.onSuccess(registerBean);
                    }
                });
    }
}
