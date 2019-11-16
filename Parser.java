import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Parser {
	//How to deal with "uneven" data?
	// key = E8TmwwqITCBMPCnFeE6Gg
	Matrix associations;
	ArrayList<String> ids = new ArrayList<String>();
	ArrayList<String[]> shelves = new ArrayList<String[]>();
	
	//help for file reading and parsing found at https://www.reddit.com/r/javaexamples/comments/344kch/reading_and_parsing_data_from_a_file/
	public void buildMatrix() {
		try {
			FileReader input = new FileReader("datasets/books.txt");
			BufferedReader br = new BufferedReader(input);
			String fileRead = br.readLine();
			boolean cont = true;
			while(cont) {
				String[] booksFromLine = fileRead.split(" ");
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
			//initialize size
			associations.setSize(ids.size(), ids.size());
			// initialize all values to zero
			for (int i = 0; i < ids.size(); i++) {
				associations.setAttrName(i, ids.get(i));
				for (int j = i; j < ids.size(); j++) {
					associations.set(i,j,0);
					associations.set(j, i, 0);
				}
			}	
			// loop through all shelves to find book associations
			for (int i = 0; i < shelves.size(); i++) {
				String[] shelf = shelves.get(i);
				addAssociations(shelf);
			}
		}
		catch (Exception e) {
			System.out.println("ERROR: Could not find file.");
		}
		
	}
	
	public void addAssociations(String[] shelf) {
		for (int i = 0; i < shelf.length; i++) {
			//int id1 = Integer.parseInt(shelf[i]);
			int index1 = ids.indexOf(shelf[i]);
			for (int j = i+1; j < shelf.length; j++) {
				//int id2 = Integer.parseInt(shelf[j]);
				int index2 = ids.indexOf(shelf[j]);
				int val = (int)associations.get(index1, index2);
				associations.set(index1, index2, val+=1);
				associations.set(index2, index1, val+=1);
			}
		}
	}
	

}
