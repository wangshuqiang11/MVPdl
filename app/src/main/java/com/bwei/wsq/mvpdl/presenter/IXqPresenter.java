package com.bwei.wsq.mvpdl.presenter;


import com.bwei.wsq.mvpdl.bean.XqBean;
import com.bwei.wsq.mvpdl.model.XqModel;
import com.bwei.wsq.mvpdl.model.imodel.IXqModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.view.iview.IXqActivity;

/**
 * Created by WSQ on 2018/1/2 0002.
 */

public class IXqPresenter {
    private IXqModel iXqModel;
    private IXqActivity iXqActivity;

    public IXqPresenter(IXqActivity iXqActivity) {
        this.iXqActivity = iXqActivity;
        iXqModel = new XqModel();
    }
    public void getxq(String pid){
        iXqModel.getXq(pid, new OnNetListener<XqBean>() {
            @Override
            public void onSuccess(XqBean xqBean) {
                iXqActivity.onxq(xqBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
