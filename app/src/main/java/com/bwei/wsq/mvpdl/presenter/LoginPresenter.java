package com.bwei.wsq.mvpdl.presenter;

import com.bwei.wsq.mvpdl.bean.LoginBean;
import com.bwei.wsq.mvpdl.model.LoginModel;
import com.bwei.wsq.mvpdl.model.imodel.ILoginModel;
import com.bwei.wsq.mvpdl.net.OnNetListener;
import com.bwei.wsq.mvpdl.view.iview.ILoginView;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public class LoginPresenter {
    private final ILoginModel iLoginModel;
    private final ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iLoginModel = new LoginModel();
    }

    public void login() {
        String mobile = iLoginView.mobile();
        String pwd = iLoginView.pwd();
        iLoginModel.login(mobile, pwd, new OnNetListener<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                iLoginView.showSuccess(loginBean.getMsg());
            }

            @Override
            public void onFailure(Exception e) {
                iLoginView.showFailure(e + "");
            }
        });
    }
}
