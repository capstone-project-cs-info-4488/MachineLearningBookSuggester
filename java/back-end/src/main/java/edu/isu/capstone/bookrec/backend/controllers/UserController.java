package edu.isu.capstone.bookrec.backend.controllers;

import edu.isu.capstone.bookrec.backend.services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
