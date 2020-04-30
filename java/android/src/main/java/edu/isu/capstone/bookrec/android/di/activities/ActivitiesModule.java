package edu.isu.capstone.bookrec.android.di.activities;

import androidx.appcompat.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.isu.capstone.bookrec.android.ui.MainActivity;
import edu.isu.capstone.bookrec.android.ui.login.LoginActivity;

@Module
public interface ActivitiesModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    MainActivity mainActivity();

    @Module(includes = {FragmentModule.class})
    interface MainActivityModule {
        @ActivityScope
        @Binds
        AppCompatActivity activity(MainActivity activity);
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    LoginActivity loginActivity();

    @Module(includes = {FragmentModule.class})
    interface LoginActivityModule {
        @ActivityScope
        @Binds
        AppCompatActivity activity(LoginActivity activity);
    }
}
