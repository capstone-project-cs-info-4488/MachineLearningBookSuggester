package edu.isu.capstone.bookrec.android.di;

import dagger.Module;
import dagger.Provides;
import edu.isu.capstone.bookrec.android.data.datasources.remote.GoodreadsClient;
import edu.isu.capstone.bookrec.android.interceptors.DeveloperKeyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
class RetrofitModule {
    @Provides
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://www.goodreads.com/")
                .client(build_client())
                .build();
    }

    @Provides
    GoodreadsClient goodreadsClient(Retrofit retrofit) {
        return retrofit.create(GoodreadsClient.class);
    }

    @Provides
    OkHttpClient build_client() {
        // Using addinterceptor rather than addnetworkinterceptor because the adjusted url should
        // already be included on redirects.
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new DeveloperKeyInterceptor())
                .build();
        return client;
    }
}
