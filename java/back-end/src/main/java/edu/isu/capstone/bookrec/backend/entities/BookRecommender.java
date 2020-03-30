package edu.isu.capstone.bookrec.backend.entities;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Set;

@Component
public class BookRecommender {
    public String recommendBook(Set<String> bookIds) {
        throw new NotImplementedException();
    }
}
