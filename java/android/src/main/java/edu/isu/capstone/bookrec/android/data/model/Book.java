package edu.isu.capstone.bookrec.android.data.model;

import java.net.URL;
import java.util.List;

public class Book {
    private final String bookId;
    private final String title;
    private final int year;
    private final List<String> authors;
    private final URL image;
    private final String description;

    public Book(String bookId, String title, int year, List<String> authors, URL image, String description) {
        this.bookId = bookId;
        this.title = title;
        this.year = year;
        this.authors = authors;
        this.image = image;
        this.description = description;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public URL getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}



