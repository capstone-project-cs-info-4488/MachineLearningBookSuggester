package edu.isu.capstone.bookrec.android.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DeveloperKeyInterceptor implements Interceptor {
    private static final String DEVELOPER_KEY_KEY = "developer_key";
    private static final String DEVELOPER_KEY = "EXGWv11xMffXLYAt4PIJQ";

    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        request.url().newBuilder().addEncodedQueryParameter(DEVELOPER_KEY_KEY, DEVELOPER_KEY);

        Response response = chain.proceed(request);
        return response;
    }

    public static OkHttpClient build_client() {
        // Using addinterceptor rather than addnetworkinterceptor because the adjusted url should
        // already be included on redirects.
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new DeveloperKeyInterceptor())
                .build();
        return client;
    }
}
