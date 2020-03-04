package edu.isu.capstone.bookrec.backend.hibernate;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author extends BaseEntity implements Serializable {
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
    private String firstName;
    private String lastName;

}
