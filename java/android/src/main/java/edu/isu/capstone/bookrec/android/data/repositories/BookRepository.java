package edu.isu.capstone.bookrec.android.data.repositories;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.Book;

public interface BookRepository {
    LiveData<Result<Book>> getBookById(String bookId);

    LiveData<Result<List<Book>>> getBooks();
}
