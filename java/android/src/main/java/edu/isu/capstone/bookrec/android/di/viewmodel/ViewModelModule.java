package edu.isu.capstone.bookrec.android.di.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import edu.isu.capstone.bookrec.android.ui.book.BookActivityViewModel;
import edu.isu.capstone.bookrec.android.ui.login.LoginViewModel;

@Module
public
interface ViewModelModule {
    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(BookActivityViewModel.class)
    ViewModel bookViewModel(BookActivityViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    ViewModel loginViewModel(LoginViewModel model);
}
