package edu.isu.capstone.bookrec.backend.repositories;

import edu.isu.capstone.bookrec.backend.entities.Book;
import edu.isu.capstone.bookrec.backend.services.BookshelfService;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class BookshelfRepository {
    private final BookshelfService bookshelfService;

    public BookshelfRepository(BookshelfService bookshelfService) {
        this.bookshelfService = bookshelfService;
    }

    public Set<Book> booksOfUser(long userId) {
        throw new UnsupportedOperationException();
    }
}
