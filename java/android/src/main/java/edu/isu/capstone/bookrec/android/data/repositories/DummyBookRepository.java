package edu.isu.capstone.bookrec.android.data.repositories;

import android.net.Uri;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.Author;
import edu.isu.capstone.bookrec.android.data.model.Book;

/**
 * TODO
 * Temporary repository that just returns DummyData
 */
public class DummyBookRepository implements BookRepository {
    private List<Book> books = Collections.singletonList(new Book("1234",
            "This is a title. Book id " + 1234,
            1998,
            Collections.singletonList(new Author("Katie Bailey")),
            Uri.parse("https://i.imgur.com/aEggkZr.jpg"),
            "This is a description"
    ));
    @Inject
    DummyBookRepository() {
    }

    @Override
    public LiveData<Result<Book>> getBookById(String bookId) {
        MutableLiveData<Result<Book>> result = new MutableLiveData<>();
        result.setValue(new Result.Success<>(books.get(0)));
        return result;
    }

    @Override
    public LiveData<Result<List<Book>>> getBooks() {
        MutableLiveData<Result<List<Book>>> ret = new MutableLiveData<>();
        ret.setValue(new Result.Success<>(Collections.unmodifiableList(books)));
        return ret;
    }
}
