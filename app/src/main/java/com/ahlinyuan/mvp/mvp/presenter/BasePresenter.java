package com.ahlinyuan.mvp.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ahlinyuan.mvp.mvp.view.IBaseView;
import com.ahlinyuan.mvp.utils.LogUtils;

/**
 * @author ahlinyuan
 * @date 2019/1/8
 * @description P层基础类
 */
public class BasePresenter<V extends IBaseView> {

    //V层 view的引用
    private V mView;

    /**
     * 获取V层接口View
     *
     * @return 返回当前View
     */
    public V getView() {
        return mView;
    }

    /**
     * v p 绑定
     *
     * @param view v
     */
    public void onAttachView(V view) {
        mView = view;
        LogUtils.d("V 和 P 绑定 v:" + mView.getClass().getName() + ",p:" + getClass().getName());
    }

    /**
     * v p解绑
     */
    public void onDetachView() {
        LogUtils.d("V 和 P 解绑 v:" + mView.getClass().getName() + ",p:" + getClass().getName());
        mView = null;
    }

    /**
     * Presenter被创建后调用
     *
     * @param savedState 被意外销毁后重建后的Bundle
     */
    public void onCreatePersenter(@Nullable Bundle savedState) {
        LogUtils.e("P onCreatePersenter = ");
    }

    /**
     * Presenter被销毁时调用
     */
    public void onDestroyPersenter() {
        LogUtils.e("P onDestroy = ");
    }

    /**
     * 在Presenter意外销毁的时候被调用，它的调用时机和Activity、Fragment、View中的onSaveInstanceState
     * 时机相同
     *
     * @param outState 意外销毁的Bundle
     */
    public void onSaveInstanceState(Bundle outState) {
        LogUtils.e("P onSaveInstanceState = ");
    }
}
