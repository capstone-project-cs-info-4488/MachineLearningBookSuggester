package edu.isu.capstone.bookrec.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
public class AuthorDetails {
    private String firstName;
    private String lastName;
    private String middleName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String gender;
}
