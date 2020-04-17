package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class UserController {
    private Environment env;

    public UserController(Environment env) {
        this.env = env;
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id) {
        throw  new NotImplementedException();
    }

    @GetMapping("/user/{username}")
    public String getUserByUsername(@PathVariable String username) {
        throw  new NotImplementedException();
    }

    @GetMapping("/user/{userId}/bookshelf/{bookshelfId}")
    public ResponseEntity<String> getUserBookshelf(@PathVariable String userId,
                                           @PathVariable String bookshelfId,
                                           RestTemplate restTemplate) {
        String APIKEY = env.getProperty("api.key");
        final String URL = String.format("https://www.goodreads.com/review/list?id=%s&shelf=%s&key=%s&v=2",
                userId, bookshelfId, APIKEY);
        return restTemplate.getForEntity(URL, String.class);
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
