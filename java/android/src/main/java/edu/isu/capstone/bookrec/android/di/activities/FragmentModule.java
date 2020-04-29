package edu.isu.capstone.bookrec.android.di.activities;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.isu.capstone.bookrec.android.ui.book.BookFragment;

@Module
public interface FragmentModule {
    @ContributesAndroidInjector
    BookFragment addBookFragment();
}
