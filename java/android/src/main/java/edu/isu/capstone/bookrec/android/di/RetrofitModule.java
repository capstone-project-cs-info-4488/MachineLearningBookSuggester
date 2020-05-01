package edu.isu.capstone.bookrec.android.di;

import com.squareup.moshi.Moshi;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import dagger.Module;
import dagger.Provides;
import edu.isu.capstone.bookrec.android.data.datasources.remote.GoodreadsClient;
import edu.isu.capstone.bookrec.android.data.moshi.UriAdapter;
import edu.isu.capstone.bookrec.android.interceptors.DeveloperKeyInterceptor;
import edu.isu.capstone.bookrec.android.util.LiveDataCallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
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
    Serializer serializer() {
        Strategy strategy = new AnnotationStrategy();
        return new Persister(strategy);
    }

    // Added deprecation suppress because it is kinda one of the very few xml libraries that works for android
    @SuppressWarnings("deprecation")
    @Provides
    Retrofit retrofit(Moshi moshi, OkHttpClient client, Serializer serializer) {
        return new Retrofit.Builder()
                .baseUrl("https://www.goodreads.com/")
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(serializer))
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build();
    }

    @Provides
    GoodreadsClient goodreadsClient(Retrofit retrofit) {
        return retrofit.create(GoodreadsClient.class);
    }

    @Provides
    OkHttpClient buildClient() {
        // Using addinterceptor rather than addnetworkinterceptor because the adjusted url should
        // already be included on redirects.
        return new OkHttpClient.Builder()
                .addInterceptor(new DeveloperKeyInterceptor())
                .build();
    }
}
