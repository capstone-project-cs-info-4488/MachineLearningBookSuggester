package edu.isu.capstone.bookrec.backend.hibernate;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String isbn_10;
    private String isbn_13;
    @Lob
    private String description;
    @ManyToMany
    @JoinTable(
            name = "Books_Authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
            )
    private Set<Author> authors = new HashSet<>();
    private int numOfPages;
    //images are stored locally and their file location is stored inside the database
    private String image;
    //TODO: rework this to possibly contain a DateTime or extract into another class
    private String month;
    private String year;
    private String day;
    //TODO: create ENUM for languages
    private String language;
}
