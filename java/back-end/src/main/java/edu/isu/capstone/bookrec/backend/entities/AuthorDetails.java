package edu.isu.capstone.bookrec.backend.entities;

import javax.persistence.Embeddable;

@Embeddable
public class AuthorDetails {
    private String firstName;
    private String lastName;
    private String middleName;
}
