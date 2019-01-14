package com.ahlinyuan.mvp.test;

import com.ahlinyuan.mvp.mvp.model.models.BaseModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.ahlinyuan.mvp.mvp.model.http.Network.API_PARAM;

public interface TestApi {

    @POST("assets.index.transfer")
    @FormUrlEncoded
    Observable<BaseModel> checkUpdate(@Field(API_PARAM) String jsonString);
}
