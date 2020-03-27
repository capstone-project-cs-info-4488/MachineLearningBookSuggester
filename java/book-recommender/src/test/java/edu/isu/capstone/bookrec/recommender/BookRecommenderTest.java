package edu.isu.capstone.bookrec.recommender;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static edu.isu.capstone.bookrec.recommender.TestUtils.hs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BookRecommenderTest {
    @Test
    void example() throws IOException {
        InputStream toLoad = getClass().getResourceAsStream("recommenderTest.txt");
        BookRecommender recommender = BookRecommender.create(toLoad, 1);

        assertNull(recommender.recommendBook(hs("Something not in the dataset")));
        assertEquals("0", recommender.recommendBook(hs("A")));
        assertEquals("1", recommender.recommendBook(hs("B")));
        assertEquals("B", recommender.recommendBook(hs("1")));
        assertEquals("A", recommender.recommendBook(hs("0")));
    }

}