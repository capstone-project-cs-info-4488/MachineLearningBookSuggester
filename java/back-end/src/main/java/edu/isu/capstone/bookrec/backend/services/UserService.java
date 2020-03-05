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
        return userRepository.findById(id);
    }

    //returns an instance of the saved class
    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public boolean checkUserExistsById(Long id) {
        return userRepository.existsById(id);
    }

}
