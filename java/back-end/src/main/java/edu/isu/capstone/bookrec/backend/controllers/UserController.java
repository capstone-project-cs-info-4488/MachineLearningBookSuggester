package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id) {
        throw  new NotImplementedException();
    }
    @GetMapping("/user/{username}")
    public String getUserByUsername(@PathVariable String username) {
        throw  new NotImplementedException();
    }
    @GetMapping("/user/{userId}/bookshelf/{bookshelfId}")
    public String getUserBookshelf(@PathVariable Long userId, @PathVariable Long bookshelfId) {
        throw new NotImplementedException();
    }
    @PostMapping("/user/{userId}/bookshelf/{bookshelfId}/add/{bookId}")
    public String addBook(@PathVariable Long userId,
                          @PathVariable Long bookshelfId,
                          @PathVariable Long bookId) {
        throw new NotImplementedException();
    }
    @PostMapping("/user/{userId}/bookshelf/create")
    public String createBookshelf(@PathVariable Long userId) {
        throw new NotImplementedException();
    }
    @DeleteMapping("/user/{userId}/bookshelf/{bookshelfId}/remove/{bookId}")
    public String removeBook(@PathVariable Long userId,
                             @PathVariable Long bookshelfId,
                             @PathVariable Long bookId) {
        throw new NotImplementedException();
    }
    @GetMapping("/user/{userId}/bookshelves")
    public String getAllBookshelves(@PathVariable Long userId) {
        throw new NotImplementedException();
    }
    @PutMapping("/user/{userId}/bookshelf/{bookshelfId}/update")
    public String updateBookshelf(@PathVariable Long userId, @PathVariable Long bookshelfId) {
        throw new NotImplementedException();
    }
}
