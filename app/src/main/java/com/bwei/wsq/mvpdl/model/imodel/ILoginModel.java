package com.bwei.wsq.mvpdl.model.imodel;

import com.bwei.wsq.mvpdl.bean.LoginBean;
import com.bwei.wsq.mvpdl.net.OnNetListener;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public interface ILoginModel {
    public void login(String mobile, String password, OnNetListener<LoginBean> onNetListener);
}
