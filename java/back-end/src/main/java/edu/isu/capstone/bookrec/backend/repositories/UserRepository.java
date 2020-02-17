package edu.isu.capstone.bookrec.backend.repositories;

import edu.isu.capstone.bookrec.backend.hibernate.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
