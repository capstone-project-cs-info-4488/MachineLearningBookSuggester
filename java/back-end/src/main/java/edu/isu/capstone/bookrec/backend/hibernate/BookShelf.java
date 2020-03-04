package edu.isu.capstone.bookrec.backend.hibernate;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class BookShelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(mappedBy = "bookShelf")
    private User user;
    @ManyToMany
    @JoinTable(
            name = "Bookshelf_Books",
            joinColumns = {@JoinColumn(name = "bookshelf_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private Set<Book> books = new HashSet<>();
}
