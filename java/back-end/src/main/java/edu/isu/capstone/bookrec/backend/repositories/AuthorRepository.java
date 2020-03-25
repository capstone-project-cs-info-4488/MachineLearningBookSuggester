package edu.isu.capstone.bookrec.backend.repositories;

import edu.isu.capstone.bookrec.backend.services.AuthorService;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {
    private final AuthorService authorService;

    public AuthorRepository(AuthorService authorService) {
        this.authorService = authorService;
    }
}
