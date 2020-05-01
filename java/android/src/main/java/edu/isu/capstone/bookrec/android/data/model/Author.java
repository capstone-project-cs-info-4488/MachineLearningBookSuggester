package edu.isu.capstone.bookrec.android.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Author {
    @Element(name = "name")
    private final String name;

    public Author(
            @Element(name = "name") String name
    ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
