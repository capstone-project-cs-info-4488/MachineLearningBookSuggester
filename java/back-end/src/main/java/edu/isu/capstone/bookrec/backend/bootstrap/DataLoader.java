package edu.isu.capstone.bookrec.backend.bootstrap;

import edu.isu.capstone.bookrec.backend.hibernate.BookShelf;
import edu.isu.capstone.bookrec.backend.hibernate.Roles;
import edu.isu.capstone.bookrec.backend.hibernate.User;
import edu.isu.capstone.bookrec.backend.hibernate.UserDetailsImpl;
import edu.isu.capstone.bookrec.backend.services.BookShelfService;
import edu.isu.capstone.bookrec.backend.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final BookShelfService bookShelfService;

    public DataLoader(UserService userService, BookShelfService bookShelfService) {
        this.userService = userService;
        this.bookShelfService = bookShelfService;
    }

    @Override
    public void run(String... args) throws Exception {
        //create test user
        User user = new User();
        //create user bookshelf
        BookShelf bookShelf = new BookShelf();
        //assign bookshelf to the user
        bookShelf.setUser(user);
        //assign bookshelf to the user
        user.setBookShelf(bookShelf);
        //setup user
        user.setUsername("user");
        user.setPassword("pass");
        //setup userDetails
        UserDetailsImpl userDetails = user.getUserDetails();
        userDetails.grantAuthority(Roles.USER);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setAccountNonExpired(true);
        userDetails.setEnabled(true);
        //save entities
        userService.save(user);
        bookShelfService.save(bookShelf);

        System.out.println("DataLoader finished");
    }
}
