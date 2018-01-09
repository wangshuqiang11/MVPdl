package com.bwei.wsq.mvpdl.view.iview;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public interface ILoginView {
    public String mobile();

    public String pwd();

    public void showSuccess(String str);

    public void showFailure(String str);
}
