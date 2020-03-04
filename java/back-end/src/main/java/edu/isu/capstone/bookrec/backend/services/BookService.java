package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
