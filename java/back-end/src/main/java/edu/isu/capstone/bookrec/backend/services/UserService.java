package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends CrudRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    Optional<UserDetails> findUserDetailsByUsername(String username);
}
