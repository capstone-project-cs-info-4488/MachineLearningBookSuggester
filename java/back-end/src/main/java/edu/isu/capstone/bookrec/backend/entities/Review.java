package edu.isu.capstone.bookrec.backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Transient
    private User user;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}
