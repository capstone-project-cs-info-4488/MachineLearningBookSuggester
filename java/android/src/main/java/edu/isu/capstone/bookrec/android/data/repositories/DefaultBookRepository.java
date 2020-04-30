package edu.isu.capstone.bookrec.android.data.repositories;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.datasources.remote.GoodreadsClient;
import edu.isu.capstone.bookrec.android.data.model.Book;

public class DefaultBookRepository implements BookRepository {
    private final GoodreadsClient goodreads;

    @Inject
    DefaultBookRepository(GoodreadsClient goodreads) {
        this.goodreads = goodreads;
    }

    @Override
    public LiveData<Result<Book>> getBookById(String bookId) {
        // Use goodreads client
        // put result into livedata.
        return null;
    }

    @Override
    public LiveData<Result<List<Book>>> getBooks() {
        return null;
    }
}
