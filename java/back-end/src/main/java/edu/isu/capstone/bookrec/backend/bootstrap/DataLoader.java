package edu.isu.capstone.bookrec.backend.bootstrap;

import edu.isu.capstone.bookrec.backend.entities.User;
import edu.isu.capstone.bookrec.backend.entities.UserDetailsImpl;
import edu.isu.capstone.bookrec.backend.services.ReviewService;
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
    private final ReviewService reviewService;

    public DataLoader(PasswordEncoder passwordEncoder,
                      UserService userService,
                      UserDetailsImplService userDetailsImplService,
                      ReviewService reviewService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userDetailsImplService = userDetailsImplService;
        this.reviewService = reviewService;
    }

    @Override
    public void run(String... args) throws Exception {
        //create test user
        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("password"));
        //create test user details
        UserDetailsImpl userDetails = new UserDetailsImpl();
        //configure user details
        userDetails.setEnabled(true);
        userDetails.setAccountNonExpired(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setUser(user);
        //save user
        user.setUserDetails(userDetails);
        userService.save(user);

//        //create review
//        Review review = new Review();
//        review.setUser(user);
//        reviewService.save(review);
//        System.out.println(review.getCreated());
    }
}
