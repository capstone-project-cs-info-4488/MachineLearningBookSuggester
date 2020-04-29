package edu.isu.capstone.bookrec.android.interceptors;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DeveloperKeyInterceptor implements Interceptor {
    private static final String DEVELOPER_KEY_KEY = "developer_key";
    private static final String DEVELOPER_KEY = "EXGWv11xMffXLYAt4PIJQ";

    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl modifiedUrl = request.url().newBuilder()
                .addEncodedQueryParameter(DEVELOPER_KEY_KEY, DEVELOPER_KEY)
                .build();

        Request modifiedRequest = request.newBuilder()
                .url(modifiedUrl)
                .build();

        Response response = chain.proceed(modifiedRequest);
        return response;
    }
}
