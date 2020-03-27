package edu.isu.capstone.bookrec.recommender;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class TestUtils {
    @SafeVarargs
    public static <T> HashSet<T> hs(T... items) {
        return new HashSet<>(asList(items));
    }
}
