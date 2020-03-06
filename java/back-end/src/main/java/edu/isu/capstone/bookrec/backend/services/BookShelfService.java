package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.hibernate.BookShelf;
import edu.isu.capstone.bookrec.backend.repositories.BookShelfRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookShelfService {
    private final BookShelfRepository bookShelfRepository;

    public BookShelfService(BookShelfRepository bookShelfRepository) {
        this.bookShelfRepository = bookShelfRepository;
    }

    public BookShelf save(BookShelf bookShelf) {
        return bookShelfRepository.save(bookShelf);
    }

    public Optional<BookShelf> findById(Long id) {
        return bookShelfRepository.findById(id);
    }
}