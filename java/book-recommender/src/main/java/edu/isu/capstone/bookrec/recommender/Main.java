package edu.isu.capstone.bookrec.recommender;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Shelves shelves = Shelves.fromBooksFile("./data/books.txt");

        List<Shelf> shelfList = shelves.getShelves();

        Apriori.Result<String> associatedBooks = Apriori.apriori(
                shelves.getShelvesAsListOfSets(),
                (int) (.001 * shelfList.size())
        );

        writeToFile(associatedBooks);
//        Apriori.Result<String> associatedBooks = readFromFile();
//        System.out.print("Read from file");

        Scanner bookScanner = new Scanner(System.in);
        System.out.println("Enter up to 2 books that you have liked to get a book recommendation (space separated): ");
        String books = bookScanner.nextLine();
        String[] booksArray = books.split(" ");
        List<String> booksList = Arrays.asList(booksArray);

        //sort through the relevant rules to find the most helpful ones
        for (Set<String> rule : associatedBooks.getSubsetsFound()) {
            if (rule.size() > booksList.size() && rule.containsAll(booksList)) {
                System.out.println(rule.toString());
            }
        }
    }

    public static void writeToFile(Apriori.Result<String> result) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("booktree.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(result);
        objectOut.close();
        System.out.println("Successfully written to file");

    }

    public static Apriori.Result<String> readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(new File("bookTree.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        @SuppressWarnings("unchecked")
        Apriori.Result<String> result = (Apriori.Result<String>) oi.readObject();

        return result;
    }

}
