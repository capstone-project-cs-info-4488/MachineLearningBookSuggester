package edu.isu.capstone.bookrec.backend.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class GoodreadsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goodreads_details_generator")
    @SequenceGenerator(name = "goodreads_details_generator", sequenceName = "goodreadsdetails_seq")
    @Setter(value = AccessLevel.NONE)
    private Long id;
    @OneToOne
    @MapsId
    private User user;
    private Long goodreadsId;
    private String goodreadsUsername;
    @Transient
    private Set<Bookshelf> bookshelves;
    @Temporal(TemporalType.DATE)
    private Date lastActive;
    @Temporal(TemporalType.DATE)
    private Date joined;
    private String Gender;
    @Transient
    private Set<Book> favoriteBooks;
    @Transient
    private Set<Author> favoriteAuthors;
}
