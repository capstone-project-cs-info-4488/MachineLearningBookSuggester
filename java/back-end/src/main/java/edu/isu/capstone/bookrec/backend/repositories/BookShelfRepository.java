package edu.isu.capstone.bookrec.backend.repositories;

import edu.isu.capstone.bookrec.backend.hibernate.BookShelf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShelfRepository extends CrudRepository<BookShelf, Long> {

}
