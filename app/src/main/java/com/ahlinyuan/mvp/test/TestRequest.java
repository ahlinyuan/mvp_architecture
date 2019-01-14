package com.ahlinyuan.mvp.test;

import com.ahlinyuan.mvp.mvp.model.http.Network;
import com.ahlinyuan.mvp.mvp.model.http.RequestParam;
import com.ahlinyuan.mvp.mvp.model.models.BaseModel;
import com.ahlinyuan.mvp.utils.LogUtils;

import io.reactivex.Observable;

public class TestRequest {

    private TestApi mApi;

    TestRequest(){
        Network network = new Network();
        mApi = network.init(TestApi.class);
    }


    Observable<BaseModel> checkUpdate(int versions) {
        RequestParam rp = new RequestParam();
        rp.put("versions", versions);
        LogUtils.e("ahlinyuan RequestParam:" + rp.toString());
        return Network.thread(mApi.checkUpdate(rp.toString()));
    }
}
