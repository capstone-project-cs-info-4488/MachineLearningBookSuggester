package edu.isu.capstone.bookrec.backend.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    @SequenceGenerator(name = "comment_generator", sequenceName = "comment_seq")
    @Setter(value = AccessLevel.NONE)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodreadsDetailsId")
    private GoodreadsDetails goodreadsDetails;
    private String comment;
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
}
