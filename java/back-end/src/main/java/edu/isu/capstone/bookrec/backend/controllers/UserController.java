package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id) {
        throw  new NotImplementedException();
    }
    @GetMapping("/user/{userId}/bookshelf/{bookshelfId}")
    public String getUserBookshelf(@PathVariable Long userId, @PathVariable Long bookshelfId) {
        throw new NotImplementedException();
    }
}
