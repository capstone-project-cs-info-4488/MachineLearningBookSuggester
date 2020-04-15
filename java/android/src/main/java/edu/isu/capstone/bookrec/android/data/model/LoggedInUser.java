package edu.isu.capstone.bookrec.android.data.model;

import java.util.List;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;
    private List<Book> recommendations;
    private List<Book> shelf;


    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<Book> getRecommendations(){return recommendations;}

    public List<Book> getShelf() { return shelf; }

    public void addShelf(Book b){
        shelf.add(b);
    }
    public void addRecommendations(Book b){
        recommendations.add(b);
    }
}
