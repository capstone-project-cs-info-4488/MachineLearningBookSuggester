package edu.isu.capstone.bookrec.backend.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
    @SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_seq")
    @Setter(value = AccessLevel.NONE)
    private long id;
    private String name;
}
