package edu.isu.capstone.bookrec.android.di;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import edu.isu.capstone.bookrec.android.BookRecommenderApplication;
import edu.isu.capstone.bookrec.android.di.activities.ActivitiesModule;
import edu.isu.capstone.bookrec.android.di.viewmodel.ViewModelModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivitiesModule.class,
        ViewModelModule.class,
        DataModule.class,
        VolleyModule.class,
        PicassoModule.class,
        ApplicationModule.class
})
public interface ApplicationComponent extends AndroidInjector<BookRecommenderApplication> {
    @Component.Factory
    interface Factory {
        ApplicationComponent create(@BindsInstance Application application);
    }
}
