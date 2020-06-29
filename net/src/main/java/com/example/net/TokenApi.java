package com.example.net;

import com.example.net.common.Config;
import com.example.net.entity.TokenRespEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TokenApi {

    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntity> getToken(
            @Field("grant_type") String grant_type,
            @Field("username") String username,
            @Field("password") String password
    );

    @Headers(Config.NewURLHeaderKey+":"+Config.NewURLHeaderValue)
    @GET("/login")
    Call<TokenRespEntity> getTest();
}
