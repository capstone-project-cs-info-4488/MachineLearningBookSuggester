package edu.isu.capstone.bookrec.android.data.model;

import android.net.Uri;

import java.util.List;

public class Book {
    private final String bookId;
    private final String title;
    private final int year;
    private final List<String> authors;
    private final Uri image;
    private final String description;

    public Book(String bookId, String title, int year, List<String> authors, Uri image, String description) {
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

    public Uri getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}



