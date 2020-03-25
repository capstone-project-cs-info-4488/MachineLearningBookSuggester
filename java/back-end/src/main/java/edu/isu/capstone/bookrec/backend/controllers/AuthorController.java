package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class AuthorController {
    @GetMapping("/author/{id}")
    public String getAuthorById(@PathVariable Long id) {
        throw new NotImplementedException();
    }
    @GetMapping("/author/{name}")
    public String getAuthorByName(@PathVariable String name) {
        throw new NotImplementedException();
    }
}
