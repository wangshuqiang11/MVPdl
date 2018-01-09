package com.bwei.wsq.mvpdl.model;

import com.bwei.wsq.mvpdl.bean.XqBean;
import com.bwei.wsq.mvpdl.model.imodel.IXqModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.net.RetrofitHelper;
import com.bwei.wsq.mvpdl.net.ServiceApi;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by WSQ on 2018/1/2 0002.
 */

public class XqModel implements IXqModel {

    @Override
    public void getXq(String pid, final OnNetListener<XqBean> onNetListener) {

        ServiceApi serverApi = RetrofitHelper.getServiceApi();
        Flowable<XqBean> xqbean = serverApi.xqbean(pid,"android");
        xqbean.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {

            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XqBean>() {
                    @Override
                    public void accept(XqBean xqBean) throws Exception {
                        onNetListener.onSuccess(xqBean);
                    }
                });
    }
}
