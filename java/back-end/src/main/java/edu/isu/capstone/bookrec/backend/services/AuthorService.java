package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService extends CrudRepository<Author, Long> {
}
