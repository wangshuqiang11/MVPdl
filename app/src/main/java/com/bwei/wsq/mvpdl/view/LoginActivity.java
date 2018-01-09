package com.bwei.wsq.mvpdl.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.wsq.mvpdl.R;
import com.bwei.wsq.mvpdl.presenter.LoginPresenter;
import com.bwei.wsq.mvpdl.view.iview.ILoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView {

    /**
     * 请输入手机号
     */
    private EditText mEtMobile;
    /**
     * 请输入密码
     */
    private EditText mEtPassword;
    /**
     * 登录
     */
    private Button mBtLogin;
    /**
     * 新用户注册
     */
    private TextView mTvRegister;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginPresenter = new LoginPresenter(this);
    }

    private void initView() {
        mEtMobile = (EditText) findViewById(R.id.et_mobile);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtLogin = (Button) findViewById(R.id.bt_login);
        mBtLogin.setOnClickListener(this);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        mTvRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_login:
                loginPresenter.login();
                
                break;
            case R.id.tv_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public String mobile() {
        return mEtMobile.getText().toString().trim();
    }

    @Override
    public String pwd() {
        return mEtPassword.getText().toString().trim();
    }

    @Override
    public void showSuccess(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailure(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}
