package com.ahlinyuan.mvp;

import android.app.Application;
import android.content.Context;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

public class MyApplication extends Application {

    /**
     * 是否是线上模式
     */
    public static final boolean ISLINE = false;

    /**
     * APP上下文实例缓存
     */
    public static Context AppCtx;

    @Override
    public void onCreate() {
        super.onCreate();
        //缓存全局上下文对象
        AppCtx = getApplicationContext();
        //初始化屏幕适配
        ScreenAdapterTools.init(this);
    }
}
