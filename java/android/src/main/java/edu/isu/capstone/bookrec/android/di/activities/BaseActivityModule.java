package edu.isu.capstone.bookrec.android.di.activities;

import androidx.appcompat.app.AppCompatActivity;
import dagger.Binds;
import dagger.Module;

@Module(includes = {FragmentModule.class})
public interface BaseActivityModule<T extends AppCompatActivity> {
    @ActivityScope
    @Binds
    AppCompatActivity activity(T activity);
}
