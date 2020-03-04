package edu.isu.capstone.bookrec.backend.services;

import edu.isu.capstone.bookrec.backend.hibernate.User;
import edu.isu.capstone.bookrec.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findUserByUserDetails_Id(id);
    }

    //returns an instance of the saved class
    public User save(User user) {
        return userRepository.save(user);
    }
}
