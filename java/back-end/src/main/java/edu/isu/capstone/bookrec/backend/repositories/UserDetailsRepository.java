package edu.isu.capstone.bookrec.backend.repositories;

import edu.isu.capstone.bookrec.backend.hibernate.UserDetailsImpl;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetailsImpl, Long> {
}
