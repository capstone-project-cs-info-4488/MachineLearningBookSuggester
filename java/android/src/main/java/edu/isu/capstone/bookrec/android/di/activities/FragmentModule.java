package edu.isu.capstone.bookrec.android.di.activities;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.isu.capstone.bookrec.android.ui.book.BookFragment;
import edu.isu.capstone.bookrec.android.ui.dashboard.DashboardFragment;

@Module
public interface FragmentModule {
    @ContributesAndroidInjector
    BookFragment addBookFragment();

    @ContributesAndroidInjector
    DashboardFragment dashboardFragment();
}
