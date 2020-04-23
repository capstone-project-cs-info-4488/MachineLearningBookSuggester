package edu.isu.capstone.bookrec.android.di;

import android.app.Application;
import android.content.Context;
import dagger.Binds;
import dagger.Module;

import javax.inject.Singleton;

@Module
public interface ApplicationModule {
    @Singleton
    @Binds
    Context context(Application app);
}
