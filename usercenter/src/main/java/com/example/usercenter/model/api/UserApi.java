package com.example.usercenter.model.api;


import androidx.lifecycle.LiveData;

import com.example.net.common.Config;
import com.example.net.entity.TokenRespEntity;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.repository.BaseRespEntity;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserApi {
    @Headers(Config.NewURLHeaderKey+":"+Config.NewURLHeaderValue)
    @GET("/login")
    Call<TokenRespEntity> getTest();

//    @POST("api/User/login")
//    LiveData<BaseRespEntity<UserEntity>> login(@Body UserEntity userEntity);
    @POST("api/User/login")
    Observable<BaseRespEntity<UserEntity>> login(@Body UserEntity userEntity);
}
