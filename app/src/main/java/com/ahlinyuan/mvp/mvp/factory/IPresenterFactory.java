package com.ahlinyuan.mvp.mvp.factory;

import com.ahlinyuan.mvp.mvp.presenter.BasePresenter;
import com.ahlinyuan.mvp.mvp.view.IBaseView;

/**
 * @author ahlinyuan
 * @date 2019/1/7
 * @description Presenter工厂接口
 */
public interface IPresenterFactory<V extends IBaseView,P extends BasePresenter<V>> {

    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createPresenter();
}
