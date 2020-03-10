package edu.isu.capstone.bookrec.recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookRecommender {

    private final Map<Set<String>, Integer> shelfSupports;

    private BookRecommender(Map<Set<String>, Integer> shelfSupports) {
        this.shelfSupports = shelfSupports;
    }

    public static BookRecommender create(File location) throws IOException {
        Shelves shelves = Shelves.fromBooksFile("./data/books.txt");

        List<Shelf> shelfList = shelves.getShelves();

        Apriori.Result<String> associatedBooks = Apriori.apriori(
                shelves.getShelvesAsListOfSets(),
                (int) (.001 * shelfList.size())
        );

        return new BookRecommender(associatedBooks.getSubsetToFrequency());
    }

    public String recommendBook(Shelf shelf) {
        //TODO
        throw new UnsupportedOperationException();
    }
}
