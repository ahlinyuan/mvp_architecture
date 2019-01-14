package com.ahlinyuan.mvp.mvp.view;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * @author ahlinyuan
 * @date 2019/1/8
 * @description V层基础接口
 */
public interface IBaseView {

    /**
     * 绑定直到销毁的生命周期
     *
     * @return 绑定的直到销毁的生命周期
     */
    <T> LifecycleTransformer<T> bindUntilDestroyEvent();
}
