package com.bwei.wsq.mvpdl.model.imodel;


import com.bwei.wsq.mvpdl.net.OnNetListener;

/**
 * Created by WSQ on 2018/1/3 0003.
 */

public interface IGetCardModel<T> {
    public void getCard(String uid, OnNetListener onNetListener);
}
