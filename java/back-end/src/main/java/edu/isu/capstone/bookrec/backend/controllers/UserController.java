package edu.isu.capstone.bookrec.backend.controllers;

import edu.isu.capstone.bookrec.backend.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String Login() {
        throw new NotImplementedException();
    }
}
