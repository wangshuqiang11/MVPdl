package com.bwei.wsq.mvpdl.model.imodel;


import com.bwei.wsq.mvpdl.bean.XqBean;
import com.bwei.wsq.mvpdl.net.OnNetListener;

/**
 * Created by WSQ on 2018/1/2 0002.
 */

public interface IXqModel {
    public void getXq(String pid, OnNetListener<XqBean> onNetListener);
}
