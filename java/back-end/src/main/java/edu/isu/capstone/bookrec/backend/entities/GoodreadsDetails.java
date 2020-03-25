package edu.isu.capstone.bookrec.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class GoodreadsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    private User user;
    private Long goodreadsId;
    private String goodreadsUsername;
    @Transient
    private Set<Bookshelf> bookshelves;
}
