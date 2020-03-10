package edu.isu.capstone.bookrec.recommender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class Shelves {
    /**
     * There is a max limit on books per shelf to speed up algorithm.
     */
    private static final int MAX_BOOKS_PER_SHELF = 10;

    private static final Logger logger = LoggerFactory.getLogger(Shelves.class);

    /**
     * The book ids across all shelves.
     */
    private final Set<String> bookIds;

    /**
     * A list of book ids in each shelf.
     */
    private final List<Shelf> shelves;

    private Shelves(Set<String> bookIds, List<Shelf> shelves) {
        this.bookIds = Collections.unmodifiableSet(bookIds);
        this.shelves = Collections.unmodifiableList(shelves);
    }

    public static Shelves fromBooksFile(String path) throws IOException {
        return fromBooksFile(new File(path));
    }

    public static Shelves fromBooksFile(File path) throws IOException {
        Set<String> ids = new HashSet<>();
        List<Shelf> shelves = new ArrayList<>();

        try (FileReader input = new FileReader(path);
             BufferedReader reader = new BufferedReader(input)
        ) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                List<String> shelfList = Arrays.asList(line.split(" "));

                // first element of the list is the user id.
                String userId = shelfList.get(0);
                List<String> bookIds = shelfList.subList(1, shelfList.size());
                if (bookIds.size() > MAX_BOOKS_PER_SHELF) {
                    bookIds = bookIds.subList(0, MAX_BOOKS_PER_SHELF);
                }
                Shelf shelf = new Shelf(userId, new HashSet<>(bookIds));

                shelves.add(shelf);
                ids.addAll(bookIds);
            }

            logger.info("Read shelves from book file.");

            return new Shelves(ids, shelves);
        } catch (IOException e) {
            logger.error("Failed to read shelves from book file", e);
            throw e;
        }
    }

    public Set<String> getBookIds() {
        return bookIds;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public List<Set<String>> getShelvesAsListOfSets() {
        return shelves.stream()
                .map(Shelf::getBookIds)
                .collect(Collectors.toList());
    }
}
