package com.ahlinyuan.mvp.mvp.factory;

import com.ahlinyuan.mvp.mvp.presenter.BasePresenter;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ahlinyuan
 * @date 2019/1/8
 * @description 标注创建Presenter的注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<? extends BasePresenter> value();
}
