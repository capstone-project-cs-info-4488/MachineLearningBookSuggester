package edu.isu.capstone.bookrec.android.ui.book;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.Book;
import edu.isu.capstone.bookrec.android.data.repositories.BookRepository;

import javax.inject.Inject;
import java.util.List;

import static androidx.lifecycle.Transformations.map;
import static androidx.lifecycle.Transformations.switchMap;

public class BookActivityViewModel extends ViewModel {
    private final MutableLiveData<String> bookId = new MutableLiveData<>();

    private final LiveData<Exception> error;
    private final LiveData<String> description;
    private final LiveData<String> title;
    private final LiveData<List<String>> authors;
    private final LiveData<Integer> yearPublished;

    @Inject
    public BookActivityViewModel(BookRepository bookRepository) {
        LiveData<Result<Book>> bookResult = switchMap(bookId, bookRepository::getBookById);
        error = switchMap(bookResult, Result::errorLiveData);
        LiveData<Book> book = switchMap(bookResult, Result::successLiveData);
        description = map(book, Book::getDescription);
        title = map(book, Book::getTitle);
        authors = map(book, Book::getAuthors);
        yearPublished = map(book, Book::getYear);
    }

    public void setBookId(String id) {
        if (!id.equals(bookId.getValue())) {
            bookId.setValue(id);
        }
    }

    public LiveData<Exception> getError() {
        return error;
    }

    public LiveData<String> getDescription() {
        return description;
    }

    public LiveData<String> getTitle() {
        return title;
    }

    public LiveData<List<String>> getAuthors() {
        return authors;
    }

    public LiveData<Integer> getYearPublished() {
        return yearPublished;
    }
}
