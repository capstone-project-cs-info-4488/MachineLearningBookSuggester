package edu.isu.capstone.bookrec.android.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "GoodreadsResponse", strict = false)
public class GoodreadsWrappedReviews {
    @ElementList
    public List<Review> reviews;
}
