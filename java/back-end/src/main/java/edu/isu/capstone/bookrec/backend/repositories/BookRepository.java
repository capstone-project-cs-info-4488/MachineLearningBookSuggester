package edu.isu.capstone.bookrec.backend.repositories;

import edu.isu.capstone.bookrec.backend.services.BookService;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final BookService bookService;

    public BookRepository(BookService bookService) {
        this.bookService = bookService;
    }
}
