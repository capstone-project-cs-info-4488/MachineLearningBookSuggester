package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class BookController {
    @GetMapping("/book/{id}")
    public String getBook(@PathVariable Long id) {
        throw new NotImplementedException();
    }
}
