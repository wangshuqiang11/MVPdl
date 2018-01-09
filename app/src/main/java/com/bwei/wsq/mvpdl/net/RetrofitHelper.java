package com.bwei.wsq.mvpdl.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WSQ on 2018/1/1 0001.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private static ServiceApi serviceApi;

    static {
        initOkHttpClient();
    }

    /**
     * 创建OkHttpClient
     */
    private static void initOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (okHttpClient == null) {
                    //设置拦截器
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(logging)//添加拦截器
                            .build();
                }
            }
        }
    }

    /**
     * 定义一个泛型方法
     *
     * @param tClass
     * @param url
     * @param <T>
     * @return
     */
    public static <T> T createAPi(Class<T> tClass, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(tClass);
    }

    /**
     * 初始化ServiceApi
     * @return
     */
    public static ServiceApi getServiceApi() {
        if (serviceApi == null) {
            synchronized (ServiceApi.class) {
                if (serviceApi == null) {
                    serviceApi = createAPi(ServiceApi.class, URL_API.BASE_URL);
                }
            }
        }
        return serviceApi;
    }
}
