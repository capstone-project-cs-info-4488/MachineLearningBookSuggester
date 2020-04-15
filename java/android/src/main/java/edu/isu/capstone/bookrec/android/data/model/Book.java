package edu.isu.capstone.bookrec.android.data.model;

import java.net.URL;
import java.util.List;

public class Book {
    private String bookId;
    private String title;
    private int year;
    private List<String> authors;
    private URL image;

    public Book(String bookId, String title, int year, List<String> authors, URL image){
        this.bookId = bookId;
        this.title = title;
        this.year = year;
        this.authors = authors;
        this.image = image;
    }

    public String getBookId(){return bookId; }
    public String getTitle(){return title;}
    public int getYear(){return year;}
    public List<String> getAuthors(){return authors;}
    public URL getImage(){return image;}

}



