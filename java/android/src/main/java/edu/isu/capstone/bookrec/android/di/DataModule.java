package edu.isu.capstone.bookrec.android.di;

import dagger.Binds;
import dagger.Module;
import edu.isu.capstone.bookrec.android.data.repositories.BookRepository;
import edu.isu.capstone.bookrec.android.data.repositories.DefaultBookRepository;

@Module
public interface DataModule {
    @Binds
    BookRepository bookRepository(DefaultBookRepository repository);
}
