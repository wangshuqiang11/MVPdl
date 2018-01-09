package com.bwei.wsq.mvpdl.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwei.wsq.mvpdl.R;
import com.bwei.wsq.mvpdl.presenter.RegisterPresenter;
import com.bwei.wsq.mvpdl.view.iview.IRegisterView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,IRegisterView {
    /**
     * 请输入手机号
     */
    private EditText mEtMobile;
    /**
     * 请输入密码
     */
    private EditText mEtPassword;
    /**
     * 注册
     */
    private Button mBtRegister;
    private ImageView mIvBack;
    private RegisterPresenter registerPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter = new RegisterPresenter(this);
        initView();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mEtMobile = (EditText) findViewById(R.id.et_mobile);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtRegister = (Button) findViewById(R.id.bt_register);
        mBtRegister.setOnClickListener(this);
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_register:
                registerPresenter.register();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_back:
                finish();
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
