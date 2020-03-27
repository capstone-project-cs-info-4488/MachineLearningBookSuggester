package edu.isu.capstone.bookrec.backend.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//TODO: create entitiy BookDetails

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_seq")
    @Setter(value = AccessLevel.NONE)
    private long id;
    private String title;
    private String isbn;
    @Transient
    private Set<Author> authors;
    @Transient
    private long avgRating;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    private Set<BookRating> ratings;
    @Transient
    private Set<Bookshelf> bookshelves;
    private int numberOfPages;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisherId")
    private Publisher publisher;
    //TODO: create enum for this
    private String language;
    private String edition;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private Set<Review> reviews;
}
