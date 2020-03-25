package edu.isu.capstone.bookrec.backend.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Transient
    private User user;
    private String comment;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
}
