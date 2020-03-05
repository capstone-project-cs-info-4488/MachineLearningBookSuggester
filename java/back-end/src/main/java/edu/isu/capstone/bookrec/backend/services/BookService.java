package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.hibernate.Author;
import edu.isu.capstone.bookrec.backend.hibernate.Book;
import edu.isu.capstone.bookrec.backend.repositories.BookRepository;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> findByTitle(String title) {
        throw new NotImplementedException();
    }

    public Optional<Book> findAllBooksWithAuthor(Author author) {
        throw new NotImplementedException();
    }
}
