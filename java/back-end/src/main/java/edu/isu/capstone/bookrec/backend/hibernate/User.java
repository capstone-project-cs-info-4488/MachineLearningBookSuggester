package edu.isu.capstone.bookrec.backend.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class User extends BaseEntity implements Serializable {
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private UserDetailsImpl userDetails = new UserDetailsImpl(this);
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_bookshelf",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "bookshelf_id")}
    )
    private BookShelf bookShelf;
}
