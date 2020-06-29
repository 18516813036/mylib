package com.example.net.common;

import com.example.net.BuildConfig;

public class Config {
    /**
     * 验证code
     */
    public final static String AUTH_CODE="651851771c11d419413f1b91b717e16312e18f1d71d91d01";
    //341de11517517819a16213218f10712d1df1fa1221471591
    /**
     * 网络请求超时时常
     */
    public final static int TIMEOUT = 10;

    public final static String BASE_URL = BuildConfig.baseUrl;

    public final static String TEST_SERVER_URL = BuildConfig.testServerUrl;

    public final static String NewURLHeaderKey = "newUrl";
    public final static String NewURLHeaderValue = "testServerUrl";
}
