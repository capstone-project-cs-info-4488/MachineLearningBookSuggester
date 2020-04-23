package edu.isu.capstone.bookrec.android.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import edu.isu.capstone.bookrec.android.data.model.Book;
import edu.isu.capstone.bookrec.android.data.repositories.BookRepository;

public class HomeViewModel extends ViewModel {
    private LiveData<List<Book>> books;
    private MutableLiveData<String> mText;
    private MutableLiveData<String> openBookEvents = new MutableLiveData<>();

    @Inject
    HomeViewModel(BookRepository bookRepository) {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
//        books = bookRepository.getBooks();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Book>> getBooks() {
        return books;
    }

    public LiveData<String> getOpenBookEvents() {
        return openBookEvents;
    }

    public void openBook(String bookId) {
        openBookEvents.setValue(bookId);
    }
}