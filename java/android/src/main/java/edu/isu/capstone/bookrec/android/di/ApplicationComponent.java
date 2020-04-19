package edu.isu.capstone.bookrec.android.di;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import edu.isu.capstone.bookrec.android.BookRecommenderApplication;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivitiesModule.class,
        ViewModelModule.class,
        DataModule.class,
        VolleyModule.class
})
public interface ApplicationComponent extends AndroidInjector<BookRecommenderApplication> {
}
