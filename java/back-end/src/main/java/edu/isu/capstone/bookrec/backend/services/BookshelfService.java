package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.entities.Bookshelf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookshelfService extends CrudRepository<Bookshelf, Long> {
}
