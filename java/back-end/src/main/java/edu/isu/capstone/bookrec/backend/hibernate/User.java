package edu.isu.capstone.bookrec.backend.hibernate;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private UserDetailsImpl userDetails = new UserDetailsImpl(this);
}
