package com.ahlinyuan.mvp.mvp.proxy;

import com.ahlinyuan.mvp.mvp.factory.IPresenterFactory;
import com.ahlinyuan.mvp.mvp.presenter.BasePresenter;
import com.ahlinyuan.mvp.mvp.view.IBaseView;

/**
 * @author ahlinyuan
 * @date 2019/1/8
 * @description 代理接口
 */
public interface IPresenterProxy<V extends IBaseView, P extends BasePresenter<V>> {

    /**
     * 设置创建Presenter的工厂
     * @param factory 工厂类
     */
    void setPresenterFactory(IPresenterFactory<V, P> factory);

    /**
     * 获取Presenter的工厂类
     * @return 返回Presenter的工厂类
     */
    IPresenterFactory<V, P> getPresenterFactory();

    /**
     * 获取Presenter对象
     * @return 返回Presenter对象
     */
    P getPresenter();
}
