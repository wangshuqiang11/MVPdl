package com.bwei.wsq.mvpdl.net;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);

    public void onFailure(Exception e);
}
