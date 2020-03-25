package edu.isu.capstone.bookrec.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private UserDetailsImpl userDetails;
}
