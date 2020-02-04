package edu.isu.capstone.bookrec.recommender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

	
	ArrayList<String> ids = new ArrayList<String>();
	ArrayList<String[]> shelves = new ArrayList<String[]>();
	
	//help for file reading and parsing found at https://www.reddit.com/r/javaexamples/comments/344kch/reading_and_parsing_data_from_a_file/
	public void FillShelves() {
		try {
			FileReader input = new FileReader("./data/books.txt");
			BufferedReader br = new BufferedReader(input);
			String fileRead = br.readLine();
			boolean cont = true;
			while(cont) {
				String[] booksFromLine = fileRead.split(" ");
				if(booksFromLine.length > 11) {
					booksFromLine = Arrays.copyOfRange(booksFromLine, 0, 11);
				}	
					shelves.add(booksFromLine);
					//First index will be the user id
					for (int i = 1; i < booksFromLine.length; i++) {
						if (ids.contains(booksFromLine[i]) == false) {
							ids.add(booksFromLine[i]);
						}
					}
					fileRead = br.readLine();
					if(fileRead == null) {
						cont = false;
					}
				
			}
			System.out.println("Sucessfully read file");
		}
		catch (Exception e) {
			System.out.println("ERROR: Could not find file.");
		}
		
	}

	

}
