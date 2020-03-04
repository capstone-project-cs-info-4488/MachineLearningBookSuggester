package edu.isu.capstone.bookrec.backend.bootstrap;

import edu.isu.capstone.bookrec.backend.hibernate.BookShelf;
import edu.isu.capstone.bookrec.backend.hibernate.User;
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
        //save entities
        userService.save(user);
        bookShelfService.save(bookShelf);

        System.out.println("DataLoader finished");
    }
}
