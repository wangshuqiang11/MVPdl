package com.bwei.wsq.mvpdl.presenter;


import com.bwei.wsq.mvpdl.bean.CartBean;
import com.bwei.wsq.mvpdl.model.GetCardModel;
import com.bwei.wsq.mvpdl.model.imodel.IGetCardModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.view.iview.IGwcActivity;

/**
 * Created by WSQ on 2018/1/3 0003.
 */

public class GetCardPresenter {
    private IGwcActivity iGwcActivity;
    private IGetCardModel iGetCardModel;

    public GetCardPresenter(IGwcActivity iGwcActivity) {
        this.iGwcActivity = iGwcActivity;
        iGetCardModel = new GetCardModel();
    }

    public void getCarts() {
        iGetCardModel.getCard("71", new OnNetListener() {
            @Override
            public void onSuccess(Object o) {
                iGwcActivity.onShoww((CartBean) o);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
