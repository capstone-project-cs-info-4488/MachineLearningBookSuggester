package edu.isu.capstone.bookrec.backend.repositories;

import edu.isu.capstone.bookrec.backend.services.BookshelfService;
import org.springframework.stereotype.Repository;

@Repository
public class BookshelfRepository {
    private final BookshelfService bookshelfService;

    public BookshelfRepository(BookshelfService bookshelfService) {
        this.bookshelfService = bookshelfService;
    }
}
