package edu.isu.capstone.bookrec.backend.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Bookshelf {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookshelf_generator")
    @SequenceGenerator(name = "bookshelf_generator", sequenceName = "bookshelf_seq")
    @Setter(value = AccessLevel.NONE)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodreadsId")
    private GoodreadsDetails goodreadsDetails;

    @Transient
    private Set<Book> books;
    private String name;
}
