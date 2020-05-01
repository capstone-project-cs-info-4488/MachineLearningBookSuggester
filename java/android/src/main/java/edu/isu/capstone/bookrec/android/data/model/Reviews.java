package edu.isu.capstone.bookrec.android.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "GoodreadsResponse")
public class Reviews {
    @Element
    public List<Review> reviews;
}
