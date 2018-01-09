package com.bwei.wsq.mvpdl.model;

import android.util.Log;

import com.bwei.wsq.mvpdl.bean.CartBean;
import com.bwei.wsq.mvpdl.model.imodel.IGetCardModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.net.RetrofitHelper;


import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by WSQ on 2018/1/3 0003.
 */

public class GetCardModel implements IGetCardModel {

    @Override
    public void getCard( String uid, final OnNetListener onNetListener) {
        Flowable<CartBean> cart = RetrofitHelper.getServiceApi().getCart(uid);
        cart.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.d("ssss","开始请求数据");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        onNetListener.onSuccess(cartBean);
                    }
                })  ;
    }
}
