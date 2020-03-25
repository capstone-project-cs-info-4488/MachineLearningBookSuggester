package edu.isu.capstone.bookrec.backend.bootstrap;

import edu.isu.capstone.bookrec.backend.entities.User;
import edu.isu.capstone.bookrec.backend.entities.UserDetailsImpl;
import edu.isu.capstone.bookrec.backend.services.UserDetailsImplService;
import edu.isu.capstone.bookrec.backend.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserDetailsImplService userDetailsImplService;

    public DataLoader(PasswordEncoder passwordEncoder, UserService userService, UserDetailsImplService userDetailsImplService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userDetailsImplService = userDetailsImplService;
    }

    @Override
    public void run(String... args) throws Exception {
        //create test user
        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("password"));
        //create test user details
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setUser(user);
        //save entities
        userService.save(user);

        userDetails.setId(user.getId());
        userDetailsImplService.save(userDetails);
    }
}
