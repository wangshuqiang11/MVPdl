package com.bwei.wsq.mvpdl.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwei.wsq.mvpdl.R;
import com.bwei.wsq.mvpdl.adapter.MyAdapter;
import com.bwei.wsq.mvpdl.bean.ShowBean;
import com.bwei.wsq.mvpdl.presenter.ShowPresenter;
import com.bwei.wsq.mvpdl.view.iview.IShowActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IShowActivity, View.OnClickListener {

    private RecyclerView mRc;
    private ShowPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new ShowPresenter(this);
        presenter.getDatas();

    }

    private void initView() {
        mRc = (RecyclerView) findViewById(R.id.rc);
        mRc.setOnClickListener(this);
    }

    @Override
    public void onshow(ShowBean.TuijianBean tuijianBean) {
        List<ShowBean.TuijianBean.ListBean> list = tuijianBean.getList();
        MyAdapter adapter = new MyAdapter(this, list);
        mRc.setAdapter(adapter);
        mRc.setLayoutManager(new GridLayoutManager(this, 1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rc:
                break;
        }
    }
}
