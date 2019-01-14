package com.ahlinyuan.mvp.mvp.proxy;

import android.os.Bundle;

import com.ahlinyuan.mvp.mvp.factory.IPresenterFactory;
import com.ahlinyuan.mvp.mvp.presenter.BasePresenter;
import com.ahlinyuan.mvp.mvp.view.IBaseView;

/**
 * @author ahlinyuan
 * @date 2019/1/8
 * @description 代理实现类，用来管理Presenter的生命周期，还有和view之间的关联
 */
public class PresenterProxy<V extends IBaseView, P extends BasePresenter<V>> implements IPresenterProxy<V, P> {

    /**
     * 获取onSaveInstanceState中bundle的key
     */
    private static final String PRESENTER_KEY = "presenter_key";

    private IPresenterFactory<V, P> mFactory;
    private P mPresenter;
    private Bundle mBundle;
    private boolean mIsAttchView;

    public PresenterProxy(IPresenterFactory<V, P> factory) {
        mFactory = factory;
    }

    @Override
    public void setPresenterFactory(IPresenterFactory<V, P> factory) {
        if (mPresenter != null) {
            throw new IllegalArgumentException("这个方法只能在getPresenter()之前调用，如果Presenter已经创建则不能再修改");
        }
        mFactory = factory;
    }

    @Override
    public IPresenterFactory<V, P> getPresenterFactory() {
        return mFactory;
    }

    @Override
    public P getPresenter() {
        if (mFactory != null) {
            if (mPresenter == null) {
                mPresenter = mFactory.createPresenter();
                mPresenter.onCreatePersenter(mBundle == null ? null : mBundle.getBundle(PRESENTER_KEY));
            }
        }
        return mPresenter;
    }

    /**
     * 绑定view
     *
     * @param view view
     */
    public void onAttchView(V view) {
        getPresenter();
        if (mPresenter != null && !mIsAttchView) {
            mPresenter.onAttachView(view);
            mIsAttchView = true;
        }
    }

    /**
     * 销毁Presenter持有的View
     */
    private void onDetachView() {
        if (mPresenter != null && mIsAttchView) {
            mPresenter.onDetachView();
            mIsAttchView = false;
        }
    }

    /**
     * 销毁Presenter
     */
    public void onDestroy() {
        if (mPresenter != null) {
            onDetachView();
            mPresenter.onDestroyPersenter();
            mPresenter = null;
        }
    }

    /**
     * 意外销毁的时候调用
     *
     * @return Bundle，存入回调给Presenter的Bundle和当前Presenter的id
     */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        getPresenter();
        if (mPresenter != null) {
            Bundle presenterBundle = new Bundle();
            //回调Presenter
            mPresenter.onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY, presenterBundle);
        }
        return bundle;
    }

    /**
     * 意外关闭恢复Presenter
     *
     * @param savedInstanceState 意外关闭时存储的Bundler
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mBundle = savedInstanceState;
    }
}
