package edu.isu.capstone.bookrec.backend.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class User extends BaseEntity implements Serializable {
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private UserDetailsImpl userDetails = new UserDetailsImpl(this);
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookshelf_id", referencedColumnName = "id")
    private BookShelf bookShelf;
}
