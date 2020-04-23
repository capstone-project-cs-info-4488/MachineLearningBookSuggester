package edu.isu.capstone.bookrec.android;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import edu.isu.capstone.bookrec.android.di.DaggerApplicationComponent;

public class BookRecommenderApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<BookRecommenderApplication> applicationInjector() {
        return DaggerApplicationComponent.factory().create(this);
    }
}
