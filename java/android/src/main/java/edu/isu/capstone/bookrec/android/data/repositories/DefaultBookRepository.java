package edu.isu.capstone.bookrec.android.data.repositories;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.datasources.remote.GoodreadsClient;
import edu.isu.capstone.bookrec.android.data.model.Book;
import edu.isu.capstone.bookrec.android.data.model.Review;

import static edu.isu.capstone.bookrec.android.util.LiveDataUtil.mapSuccess;

public class DefaultBookRepository implements BookRepository {
    private final GoodreadsClient goodreads;
    private final LoginRepository login;

    @Inject
    DefaultBookRepository(GoodreadsClient goodreads, LoginRepository login) {
        this.goodreads = goodreads;
        this.login = login;
    }

    @Override
    public LiveData<Result<Book>> getBookById(String bookId) {
        // Use goodreads client
        // put result into livedata.
        return null;
    }

    @Override
    public LiveData<Result<List<Book>>> getBooks() {
        String goodReadsId = login.goodreadsId();
        return mapSuccess(goodreads.getBooks(2, goodReadsId), reviews -> {
            List<Book> result = new ArrayList<>();
            for (Review review : reviews.reviews) {
                result.add(review.book);
            }
            return result;
        });
    }
}
