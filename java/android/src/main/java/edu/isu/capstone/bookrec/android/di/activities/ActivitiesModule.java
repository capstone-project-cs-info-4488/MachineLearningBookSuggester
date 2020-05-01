package edu.isu.capstone.bookrec.android.di.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import edu.isu.capstone.bookrec.android.ui.MainActivity;
import edu.isu.capstone.bookrec.android.ui.login.LoginActivity;

@Module
public interface ActivitiesModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    MainActivity mainActivity();

    @Module(includes = {CommonModule.class})
    interface MainActivityModule {
        @ActivityScope
        @Binds
        AppCompatActivity activity(MainActivity activity);
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    LoginActivity loginActivity();

    @Module(includes = {CommonModule.class})
    interface LoginActivityModule {
        @ActivityScope
        @Binds
        AppCompatActivity activity(LoginActivity activity);
    }

    @Module(includes = FragmentModule.class)
    interface CommonModule {
        @ActivityScope
        @Provides
        static ActionBar toolbar(AppCompatActivity activity) {
            return activity.getSupportActionBar();
        }
    }
}
