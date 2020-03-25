package edu.isu.capstone.bookrec.backend.repositories;

import edu.isu.capstone.bookrec.backend.entities.User;
import edu.isu.capstone.bookrec.backend.entities.UserDetailsImpl;
import edu.isu.capstone.bookrec.backend.services.UserDetailsImplService;
import edu.isu.capstone.bookrec.backend.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("UserDetailsServiceImpl")
public class UserRepository  implements UserDetailsService {
    private final UserService userService;
    private final UserDetailsImplService userDetailsImplServive;

    public UserRepository(UserService userService, UserDetailsImplService userDetailsImplServive) {
        this.userService = userService;
        this.userDetailsImplServive = userDetailsImplServive;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findUserByUsername(username);
        if (user.isPresent()) {
            Long userId = user.get().getId();
            System.out.println(userId);
            Optional<UserDetailsImpl> userDetails = userDetailsImplServive.findById(userId);
            System.out.println(userDetails.isPresent());
            return userDetails.orElseThrow(() -> new UsernameNotFoundException("User is: " + userId + " not found!"));
        }
        throw new UsernameNotFoundException(String.format("Username: %s not found!", username));
    }
}
