package edu.isu.capstone.bookrec.android.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.Book;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;


public class DefaultBookRepository implements BookRepository {
    @Inject
    public DefaultBookRepository() {
    }

    @Override
    public LiveData<Result<Book>> getBookById(String bookId) {
        MutableLiveData<Result<Book>> result = new MutableLiveData<>();
        try {
            result.setValue(new Result.Success<>(new Book("1234",
                    "This is a title",
                    1998,
                    Collections.singletonList("Katie Bailey"),
                    new URL("https://i.imgur.com/aEggkZr.jpg"),
                    "This is a description"
            )));
        } catch (MalformedURLException e) {
            result.setValue(new Result.Error<>(e));
        }
        return result;
    }
}
