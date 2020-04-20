package edu.isu.capstone.bookrec.android.data.repositories;

import android.net.Uri;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Collections;

import javax.inject.Inject;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.Book;

/**
 * TODO
 * Temporary repository that just returns DummyData
 */
public class DummyBookRepository implements BookRepository {
    @Inject
    DummyBookRepository() {
    }

    @Override
    public LiveData<Result<Book>> getBookById(String bookId) {
        MutableLiveData<Result<Book>> result = new MutableLiveData<>();
        result.setValue(new Result.Success<>(new Book("1234",
                "This is a title. Book id " + bookId,
                1998,
                Collections.singletonList("Katie Bailey"),
                Uri.parse("https://i.imgur.com/aEggkZr.jpg"),
                "This is a description"
        )));
        return result;
    }
}