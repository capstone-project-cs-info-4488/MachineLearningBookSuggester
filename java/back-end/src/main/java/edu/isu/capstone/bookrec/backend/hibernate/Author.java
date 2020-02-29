package edu.isu.capstone.bookrec.backend.hibernate;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
