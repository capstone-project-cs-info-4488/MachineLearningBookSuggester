package edu.isu.capstone.bookrec.android.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.isu.capstone.bookrec.android.ui.book.BookActivity;

@Module
public interface ActivitiesModule {
    @ContributesAndroidInjector
    BookActivity addBookActivity();
}
