package edu.isu.capstone.bookrec.android.di;

import android.content.Context;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PicassoModule {
    @Singleton
    @Provides
    Picasso picasso(Context context) {
        return new Picasso.Builder(context).build();
    }
}
