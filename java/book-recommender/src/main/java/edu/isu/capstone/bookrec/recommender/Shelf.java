package edu.isu.capstone.bookrec.recommender;

import java.util.Set;

public class Shelf {
    private final String userId;
    private final Set<String> bookIds;

    public Shelf(String userId, Set<String> bookIds) {
        this.userId = userId;
        this.bookIds = bookIds;
    }

    public String getUserId() {
        return userId;
    }

    public Set<String> getBookIds() {
        return bookIds;
    }
}
