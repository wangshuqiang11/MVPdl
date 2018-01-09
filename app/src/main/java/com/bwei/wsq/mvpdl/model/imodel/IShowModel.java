package com.bwei.wsq.mvpdl.model.imodel;


import com.bwei.wsq.mvpdl.bean.ShowBean;
import com.bwei.wsq.mvpdl.net.OnNetListener;

/**
 * Created by WSQ on 2018/1/2 0002.
 */

public interface IShowModel {
    public void getData(OnNetListener<ShowBean> onNetListener);
}
