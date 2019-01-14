package com.ahlinyuan.mvp.test;

import android.os.Bundle;

import com.ahlinyuan.mvp.R;
import com.ahlinyuan.mvp.mvp.factory.CreatePresenter;
import com.ahlinyuan.mvp.mvp.view.BaseActivity;

@CreatePresenter(TestPresenter.class)
public class MainActivity extends BaseActivity<ITestView, TestPresenter> implements ITestView {


    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        findViewById(R.id.tv).setOnClickListener(v -> getPresenter().checkUpdate(1));
    }

    @Override
    public void onReusult(String str) {
        toast(str);
    }
}
