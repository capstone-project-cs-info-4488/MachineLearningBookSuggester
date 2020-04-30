package edu.isu.capstone.bookrec.android.di;

import dagger.Binds;
import dagger.Module;
import edu.isu.capstone.bookrec.android.data.repositories.BookRepository;
import edu.isu.capstone.bookrec.android.data.repositories.DefaultLoginRepository;
import edu.isu.capstone.bookrec.android.data.repositories.DummyBookRepository;
import edu.isu.capstone.bookrec.android.data.repositories.LoginRepository;

@Module
public interface DataModule {
    @Binds
    BookRepository bookRepository(DummyBookRepository repository);

    @Binds
    LoginRepository loginRepository(DefaultLoginRepository repository);
}
