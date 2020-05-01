package edu.isu.capstone.bookrec.android.di;

import com.squareup.moshi.Moshi;

import dagger.Module;
import dagger.Provides;
import edu.isu.capstone.bookrec.android.data.datasources.remote.GoodreadsClient;
import edu.isu.capstone.bookrec.android.data.moshi.UriAdapter;
import edu.isu.capstone.bookrec.android.util.LiveDataCallAdapterFactory;
import edu.isu.capstone.bookrec.android.interceptors.DeveloperKeyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
class RetrofitModule {
    @Provides
    Moshi moshi() {
        return new Moshi.Builder()
                .add(new UriAdapter())
                .build();
    }

    @Provides
    Retrofit retrofit(Moshi moshi) {
        return new Retrofit.Builder()
                .baseUrl("https://www.goodreads.com/")
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addConverterFactory(SimpleXmlConverterFactory.create())
//                .addConverterFactory(MoshiConverterFactory.create(moshi))
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
