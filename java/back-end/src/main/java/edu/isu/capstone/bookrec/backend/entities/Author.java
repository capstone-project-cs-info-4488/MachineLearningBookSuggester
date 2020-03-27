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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
    @SequenceGenerator(name = "author_generator", sequenceName = "author_seq")
    @Setter(value = AccessLevel.NONE)
    private long id;
    @Embedded
    private AuthorDetails authorDetails;
    @Transient
    private Set<Book> books;
}
