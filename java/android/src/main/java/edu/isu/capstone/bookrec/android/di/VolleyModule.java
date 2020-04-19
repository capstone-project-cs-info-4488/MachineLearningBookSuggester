package edu.isu.capstone.bookrec.android.di;

import dagger.Module;
import dagger.Provides;
import edu.isu.capstone.bookrec.android.data.datasources.remote.BookFetcher;
import edu.isu.capstone.bookrec.android.data.datasources.remote.Fetcher;
import edu.isu.capstone.bookrec.android.data.datasources.remote.LoggedInUserFetcher;
import edu.isu.capstone.bookrec.android.data.datasources.remote.VolleySingleton;
import edu.isu.capstone.bookrec.android.data.model.Book;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

@Module
public class VolleyModule {
    @Provides
    Fetcher<LoggedInUser> loggedInUserFetcher(VolleySingleton volley) {
        return new LoggedInUserFetcher(volley, "http://localhost:8080/user");
    }

    @Provides
    Fetcher<Book> bookFetcher(VolleySingleton volley) {
        return new BookFetcher(volley, "http://localhost:8080/book");
    }
}
