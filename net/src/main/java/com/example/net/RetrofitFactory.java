package com.example.net;

import android.text.TextUtils;
import android.util.Log;

import com.example.common.utils.LogUtils;
import com.example.net.common.Config;
import com.example.net.entity.TokenRespEntity;
import com.example.storage.core.StorageManager;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private volatile static RetrofitFactory instance;
    private Retrofit retrofit;

    private RetrofitFactory() {
        initRetrofit();
    }

    private void initRetrofit() {
        LogUtils.i("校验网址——BaseUrl："+Config.BASE_URL);
        retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //.addCallAdapterFactory(LiveDataAdapterFactory.create())
                .build();
    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(Config.TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Config.TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Config.TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(createNetwordInterceptor())
                .addInterceptor(tokenInterceptor())
                //.addInterceptor(headerParamsInterceptor())
                .build();
        return client;
    }

    /**
     * 头信息拦截器
     * @return
     */
    private Interceptor headerParamsInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request newRequest = request.newBuilder()
                        .addHeader("", "")
                        .addHeader("", "")
                        .build();
                return chain.proceed(newRequest);
            }
        };
        return interceptor;
    }

    private Interceptor changeBaseUrl(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl oldUrl = request.url();
                Request.Builder newBuilder = request.newBuilder();
                List<String> headers = request.headers(Config.NewURLHeaderKey);
                if (headers!=null && headers.size()>0){
                    newBuilder.removeHeader(Config.NewURLHeaderKey);
                    String headerValue = headers.get(0);
                    HttpUrl newBaseUrl = null;
                    if (headerValue.equals(Config.NewURLHeaderValue)) {
                        newBaseUrl = HttpUrl.parse(Config.TEST_SERVER_URL);
                    }else {
                        newBaseUrl = oldUrl;
                    }
                    HttpUrl newUrl = oldUrl.newBuilder()
                            .scheme(newBaseUrl.scheme())
                            .host(newBaseUrl.host())
                            .port(newBaseUrl.port())
                            .build();
                    Request newRequest = newBuilder.url(newUrl).build();
                    return chain.proceed(newRequest);
                }
                return chain.proceed(request);
            }
        };
        return interceptor;
    }

    private Interceptor tokenInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                LogUtils.i("校验Token："+response.code());
                //如果校验失败
                if (response.code() == 401) {
                    String tokenstr = requestToken();
                    if (TextUtils.isEmpty(tokenstr)) {
                        //异常
                        LogUtils.i("校验Token：token为null");
                        return response;
                    }
                    //todo 保存Token到SP
                    StorageManager.getInstance().save("token",tokenstr);

                    LogUtils.i("校验Token：token——"+tokenstr);
                    //重新构建请求头
                    Request newRequest = request.newBuilder()
                            .addHeader("Authorization", "bearer "+tokenstr)
                            .build();
                    return chain.proceed(newRequest);
                }
                return response;
            }
        };
        return interceptor;
    }

    /**
     * 网络请求拦截器
     * @return
     */
    private Interceptor createNetwordInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    public static RetrofitFactory getInstance(){
        if (instance == null){
            synchronized (RetrofitFactory.class){
                if (instance == null){
                    instance = new RetrofitFactory();
                }
            }
        }
        return instance;
    }

    //网路获取token方法
    private TokenRespEntity oldRequestToken() throws IOException {
        TokenApi tokenApi = create(TokenApi.class);
        Call<TokenRespEntity> service = tokenApi.getToken("password", Config.AUTH_CODE, "");
        retrofit2.Response<TokenRespEntity> result = service.execute();
        if (result != null && result.body() != null){
            return result.body();
        }
        return null;
    }

    private String requestToken() {

        TokenApi tokenApi = create(TokenApi.class);
        Call<TokenRespEntity> tokenService = tokenApi.getToken("password", Config.AUTH_CODE, "");
        try {
            retrofit2.Response<TokenRespEntity> result = tokenService.execute();
            if (result!=null&&result.body()!=null){
                return  result.body().getAccess_token();
            }
        } catch (IOException e) {
            LogUtils.i(e.getMessage());
        }
        return "";
    }

    public <T> T create(Class<T> t){
        return retrofit.create(t);
    }
}
