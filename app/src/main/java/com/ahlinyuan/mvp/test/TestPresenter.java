package com.ahlinyuan.mvp.test;

import android.annotation.SuppressLint;

import com.ahlinyuan.mvp.mvp.presenter.BasePresenter;

public class TestPresenter extends BasePresenter<ITestView> {

    TestRequest mTestRequest;

    public TestPresenter(){
        mTestRequest = new TestRequest();
    }

    @SuppressLint("CheckResult")
    void checkUpdate(int v){
        mTestRequest.checkUpdate(v).compose(getView().bindUntilDestroyEvent()).subscribe(baseModel -> {
            if(baseModel.isResponseSuccess()){
                getView().success("成功");
            }else{
                getView().success("失败");
            }
        }, e -> getView().success("失败"));
    }
}
