package com.bwei.wsq.mvpdl.model.imodel;

import com.bwei.wsq.mvpdl.bean.RegisterBean;
import com.bwei.wsq.mvpdl.net.OnNetListener;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public interface IRegisterModel {
    public void register(String mobile, String password, OnNetListener<RegisterBean> onNetListener);
}
