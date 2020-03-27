package edu.isu.capstone.bookrec.backend.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BookRating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_rating_generator")
    @SequenceGenerator(name = "book_rating_generator", sequenceName = "bookrating_seq")
    @Setter(value = AccessLevel.NONE)
    private long id;
    @Transient
    private Book book;
    @Transient
    private User user;
    private int rating;
}
