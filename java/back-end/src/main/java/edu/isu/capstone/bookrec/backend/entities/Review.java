package edu.isu.capstone.bookrec.backend.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
    @SequenceGenerator(name = "review_generator", sequenceName = "review_seq")
    @Setter(value = AccessLevel.NONE)
    private long id;
    @Transient
    private User user;
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    @CreationTimestamp
    private Date created;
}
