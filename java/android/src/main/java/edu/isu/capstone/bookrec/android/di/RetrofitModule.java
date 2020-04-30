package edu.isu.capstone.bookrec.android.di;

import dagger.Module;
import dagger.Provides;
import edu.isu.capstone.bookrec.android.data.datasources.remote.GoodreadsClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class RetrofitModule {
    @Provides
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://www.goodreads.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    GoodreadsClient goodreadsClient(Retrofit retrofit) {
        return retrofit.create(GoodreadsClient.class);
    }
}
