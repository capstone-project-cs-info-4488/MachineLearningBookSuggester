package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.entities.UserDetailsImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserDetailsImplService extends CrudRepository<UserDetailsImpl, Long> {
    Optional<UserDetailsImpl> findById(Long id);
}
