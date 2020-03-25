package edu.isu.capstone.bookrec.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String isbn;
    @Transient
    private Set<Author> authors;
    @Transient
    private long avgRating;
    @Transient
    private BookRating rating;
    @Transient
    private Set<Bookshelf> bookshelves;
}
