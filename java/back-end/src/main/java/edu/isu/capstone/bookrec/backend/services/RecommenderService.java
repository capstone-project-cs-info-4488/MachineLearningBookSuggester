package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.entities.Book;
import edu.isu.capstone.bookrec.backend.repositories.BookshelfRepository;
import edu.isu.capstone.bookrec.recommender.BookRecommender;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class RecommenderService {
    private final BookshelfRepository bookshelfRepository;
    private final BookRecommender recommender;

    public RecommenderService(BookshelfRepository bookshelfRepository, BookRecommender recommender) {
        this.bookshelfRepository = bookshelfRepository;
        this.recommender = recommender;
    }

    private String bookRecommendationId(Book book) {
        return Long.toString(book.getId());
    }

    private Long bookRecommendationIdToBookId(String bookRecommendationId) {
        return Long.parseLong(bookRecommendationId);
    }

    public Set<Long> recommendBooks(long userId) {
        Set<Book> usersBooks = bookshelfRepository.booksOfUser(userId);
        Set<String> bookIds = usersBooks
                .stream()
                .map(this::bookRecommendationId)
                .collect(toSet());

        String recommendationId = recommender.recommendBook(bookIds);

        if (recommendationId != null) {
            return Collections.singleton(bookRecommendationIdToBookId(recommendationId));
        } else {
            return Collections.emptySet();
        }
    }
}
