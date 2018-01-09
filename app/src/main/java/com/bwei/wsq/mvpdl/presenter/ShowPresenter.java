package com.bwei.wsq.mvpdl.presenter;


import com.bwei.wsq.mvpdl.bean.ShowBean;
import com.bwei.wsq.mvpdl.model.ShowModel;
import com.bwei.wsq.mvpdl.model.imodel.IShowModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.view.iview.IShowActivity;

/**
 * Created by WSQ on 2018/1/2 0002.
 */

public class ShowPresenter {
    private IShowModel iShowModel;
    private IShowActivity iShowActivity;

    public ShowPresenter(IShowActivity iShowActivity) {
        this.iShowActivity = iShowActivity;
        iShowModel = new ShowModel();
    }
    public void getDatas(){
        iShowModel.getData(new OnNetListener<ShowBean>() {
            @Override
            public void onSuccess(ShowBean showBean) {
                iShowActivity.onshow(showBean.getTuijian());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
