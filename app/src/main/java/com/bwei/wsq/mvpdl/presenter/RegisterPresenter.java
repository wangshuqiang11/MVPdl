package com.bwei.wsq.mvpdl.presenter;

import com.bwei.wsq.mvpdl.bean.RegisterBean;
import com.bwei.wsq.mvpdl.model.RegisterModel;
import com.bwei.wsq.mvpdl.model.imodel.IRegisterModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.view.iview.IRegisterView;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public class RegisterPresenter {
    private final IRegisterModel iRegisterModel;
    private final IRegisterView iRegisterView;

    public RegisterPresenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        iRegisterModel = new RegisterModel();
    }

    public void register() {
        String mobile = iRegisterView.mobile();
        String pwd = iRegisterView.pwd();
        iRegisterModel.register(mobile, pwd, new OnNetListener<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                iRegisterView.showSuccess(registerBean.getMsg());
            }

            @Override
            public void onFailure(Exception e) {
                iRegisterView.showFailure(e+"");
            }
        });
    }
}
