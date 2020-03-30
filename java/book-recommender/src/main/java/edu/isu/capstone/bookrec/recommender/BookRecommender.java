package edu.isu.capstone.bookrec.recommender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class BookRecommender implements Serializable {
    public static final String TRAINING_DATA_LOCATION = "trainingData.txt";
    public static final int DEFAULT_MIN_SUPPORT = 2;
    private static final Logger logger = LoggerFactory.getLogger(BookRecommender.class);

    private final Map<Set<String>, Integer> shelfSupports;

    public BookRecommender(Map<Set<String>, Integer> shelfSupports) {
        this.shelfSupports = shelfSupports;
    }

    /**
     * @param trainingData Location of training data.
     * @param minSupport   The minimum support to be used from the training data.
     * @return A book recommender
     * @throws IOException If there is a problem reading the training data.
     */
    public static BookRecommender create(InputStream trainingData, int minSupport) throws IOException {
        if (minSupport < 1) {
            logger.warn("Creating a book recommender with min support not at least 1.");
        }

        Shelves shelves = Shelves.fromDataStream(trainingData);

        Apriori.Result<String> associatedBooks = Apriori.apriori(
                shelves.getShelvesAsListOfSets(),
                minSupport
        );

        return new BookRecommender(associatedBooks.getSubsetToFrequency());
    }

    /**
     * Creates the default book recommender by looking for the training data as a resource identified by
     * TRAINING_DATA_LOCATION.
     *
     * @return The default book recommender.
     * @throws IOException If there are problems finding the data.
     */

    public static BookRecommender createDefault() throws IOException {
        try (InputStream data = getSystemResourceAsStream(TRAINING_DATA_LOCATION)) {
            if (data == null) {
                logger.error("Unable to find training data.");
                return null;
            }
            return create(data, DEFAULT_MIN_SUPPORT);
        }
    }

    /**
     * Recommend a book for the given shelf.
     *
     * @param shelf a list of book ids.
     * @return the book id of the book to recommend. Returns null if the learned data has no relationship to the shelf.
     */

    public String recommendBook(Set<String> shelf) {
        // NOTE THAT THIS IS EXTREMELY INEFFICIENT AND NOT CURRENTLY SCALABLE
        String bestBook = null;
        double bestLift = 0;

        for (Map.Entry<Set<String>, Integer> shelfSupport : shelfSupports.entrySet()) {
            Set<String> exampleShelf = shelfSupport.getKey();

            // Calculate intersection
            Set<String> shared = new HashSet<>(shelf);
            shared.retainAll(exampleShelf);
            if (shared.isEmpty() || shared.size() == exampleShelf.size()) {
                continue;
            }
            int exampleSupport = shelfSupport.getValue();
            int sharedSupport = support(shared);

            for (String candidate : exampleShelf) {
                if (shared.contains(candidate)) {
                    continue;
                }
                int candidateSupport = support(candidate);
                double lift = calculateLift(exampleSupport, sharedSupport, candidateSupport);
                if (lift > bestLift) {
                    bestLift = lift;
                    bestBook = candidate;
                }
            }
        }

        return bestBook;
    }

    /**
     * Calculates the lift.
     * The higher the lift, the more unusually likely the candidateBook is.
     *
     * @return the lift
     */
    private double calculateLift(int combinedSupport, int conditionSupport, int candidateSupport) {
        return (double) combinedSupport / conditionSupport / candidateSupport;
    }

    /**
     * Calculates the support of the single book. This is how many times it appeared in users shelves.
     *
     * @param book The book to get the support of
     * @return the support of the book.
     */
    private int support(String book) {
        return support(Collections.singleton(book));
    }

    /**
     * Returns the support of a set of books. The support is how many times the set appeared as a subset of someone's
     * shelf.
     *
     * @param books The books to get the support of
     * @return the support
     */
    private int support(Set<String> books) {
        return shelfSupports.getOrDefault(books, 0);
    }
}
