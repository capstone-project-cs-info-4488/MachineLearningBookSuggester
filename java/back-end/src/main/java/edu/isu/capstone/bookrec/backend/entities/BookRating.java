package edu.isu.capstone.bookrec.backend.entities;

import javax.persistence.*;

@Entity
public class BookRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Transient
    private Book book;
    @Transient
    private User user;
    private int rating;
}
