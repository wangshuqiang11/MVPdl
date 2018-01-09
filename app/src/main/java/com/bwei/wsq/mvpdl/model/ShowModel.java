package com.bwei.wsq.mvpdl.model;

import com.bwei.wsq.mvpdl.bean.ShowBean;
import com.bwei.wsq.mvpdl.model.imodel.IShowModel;
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

public class ShowModel implements IShowModel {

    @Override
    public void getData(final OnNetListener<ShowBean> onNetListener) {
        ServiceApi serverApi = RetrofitHelper.getServiceApi();
        Flowable<ShowBean> tuijianbean = serverApi.showbean();
        tuijianbean.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {

            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowBean>() {
                    @Override
                    public void accept(ShowBean showBean) throws Exception {
                        onNetListener.onSuccess(showBean);
                    }
                });
    }
}
