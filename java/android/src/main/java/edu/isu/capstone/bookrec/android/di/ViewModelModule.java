package edu.isu.capstone.bookrec.android.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import edu.isu.capstone.bookrec.android.ui.book.BookActivityViewModel;

@Module
interface ViewModelModule {
    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(BookActivityViewModel.class)
    ViewModel bindBookViewModel(BookActivityViewModel model);
}
