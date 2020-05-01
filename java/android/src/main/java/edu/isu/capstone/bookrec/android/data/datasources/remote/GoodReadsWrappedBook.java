package edu.isu.capstone.bookrec.android.data.datasources.remote;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import edu.isu.capstone.bookrec.android.data.model.Book;

@Root(name = "GoodreadsResponse")
public class GoodReadsWrappedBook {
    @Element
    public Book book;
}
