package edu.isu.capstone.bookrec.backend.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
    ----GoodreadsDetails----
    User has a OneToOne mapping with GoodreadsDetails.
    This association is unidirectional for performance reasons and is a best practice
    ----UserDetailsImpl----
    User has a OneToOne mapping with UserDetailsImpl
    This association is bidirectional and thus EAGER (always fetched when the owning entity is)
    This is done because it is always needed
*/

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 3)
    @Setter(value = AccessLevel.NONE)
    private long id;
    private String username;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private UserDetailsImpl userDetails;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private GoodreadsDetails goodreadsDetails;
}
