import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Data {
	
	// key = E8TmwwqITCBMPCnFeE6Gg
	Matrix associations;
	ArrayList<String> titles = new ArrayList<String>();
	ArrayList<String[]> allBooks = new ArrayList<String[]>();
	
	//help for file reading and parsing found at https://www.reddit.com/r/javaexamples/comments/344kch/reading_and_parsing_data_from_a_file/
	public void buildMatrix() {
		try {
			FileReader input = new FileReader("datasets/books.txt");
			BufferedReader br = new BufferedReader(input);
			String fileRead = br.readLine();
			boolean cont = true;
			while(cont) {
				String[] booksFromLine = fileRead.split(",");
				allBooks.add(booksFromLine);
				for (int i = 0; i < booksFromLine.length; i++) {
					if (titles.contains(booksFromLine[i]) == false) {
						titles.add(booksFromLine[i]);
					}
				}
				fileRead = br.readLine();
				if(fileRead == null) {
					cont = false;
				}
			}
			//initialize size
			associations.setSize(titles.size(), titles.size());
			// initialize all values to zero
			for (int i = 0; i < titles.size(); i++) {
				associations.setAttrName(i, titles.get(i));
				for (int j = 0; j < titles.size(); j++) {
					associations.set(i,j,0);
				}
			}	
			// loop through all shelves to find book associations
			for (int i = 0; i < titles.size(); i++) {
				
				for (int j = 0; j < allBooks.size(); j++){
					
				}
			}
		}
		catch (Exception e) {
			System.out.println("ERROR: Could not find file.");
		}
		
	}
	
	
	public int Count(String title, String[] ) {
		
	}

}
