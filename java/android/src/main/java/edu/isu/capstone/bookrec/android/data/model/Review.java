package edu.isu.capstone.bookrec.android.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public
class Review {
    @Element
    public Book book;
}
