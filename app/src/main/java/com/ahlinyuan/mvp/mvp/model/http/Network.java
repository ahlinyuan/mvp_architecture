package com.ahlinyuan.mvp.mvp.model.http;


import com.ahlinyuan.mvp.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ahlinyuan.mvp.MyApplication.ISLINE;

public class Network {

    /**
     * 参数名
     */
    public static final String API_PARAM = "param";


    //初始化================
    private static String URL = "http://192.168.1.xxx/";
    //测试URL
    private final static String URL_DEBUG = "http://192.168.31.51:8088/";
    //正式URL
    private final static String URL_RELEASE = "http://192.168.1.xxx/";


//    private Network() {
//    }
//
//    private static class SingleNetwork {
//        private static Network INSTANCE = new Network();
//    }
//
//    public static Network getInstance() {
//        return SingleNetwork.INSTANCE;
//    }


    /**
     * 初始化网络请求，在Application创建的时候调用,确保只初始化一次
     */
    public <T> T init(Class<T> clazz) {
        URL = ISLINE ? URL_RELEASE : URL_DEBUG;
        Retrofit.Builder rBuilder = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        OkHttpClient.Builder oBuilder = new OkHttpClient.Builder();
        //公共头拦截器
        oBuilder.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
//                    .header("token", "")
                    .header("version", "1.0")
//                    .header("language", "")
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        });
        //DEBUG模式,添加日志拦截器
        if (!ISLINE) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            oBuilder.addInterceptor(interceptor);
        }
        rBuilder.client(oBuilder.build());

        T NetworkApi = rBuilder.build().create(clazz);
        LogUtils.e("网络API初始化完成");
        return NetworkApi;
    }

    //线程切换部分=============

    /**
     * 网络请求的线程
     */
    public static <T> Observable<T> thread(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    //网络请求==================

}
