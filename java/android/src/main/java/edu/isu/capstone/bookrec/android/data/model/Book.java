package edu.isu.capstone.bookrec.android.data.model;

import android.net.Uri;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

import java.util.List;

import edu.isu.capstone.bookrec.android.util.ObjectUtil;
import edu.isu.capstone.bookrec.android.util.SimpleXmlUriConverter;

@Root
public class Book {
    @Element(name = "id")
    private final String bookId;

    @Element(name = "title")
    private final String title;

    @Element(name = "publication_year")
    private final int year;

    @ElementList(name = "authors")
    private final List<Author> authors;

    @Element(name = "image_url")
    @Convert(SimpleXmlUriConverter.class)
    private final Uri image;

    @Element(name = "description")
    private final String description;

    public Book(
            @Element(name = "id") String bookId,
            @Element(name = "title") String title,
            @Element(name = "publication_year") int year,
            @ElementList(name = "authors") List<Author> authors,
            @Element(name = "image_url") @Convert(SimpleXmlUriConverter.class) Uri image,
            @Element(name = "description") String description
    ) {
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

    public List<Author> getAuthors() {
        return authors;
    }

    public Uri getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                ObjectUtil.equals(bookId, book.bookId) &&
                ObjectUtil.equals(title, book.title) &&
                ObjectUtil.equals(authors, book.authors) &&
                ObjectUtil.equals(image, book.image) &&
                ObjectUtil.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return ObjectUtil.hash(bookId, title, year, authors, image, description);
    }
}



