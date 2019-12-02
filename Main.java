import java.awt.print.Printable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.directory.InvalidSearchControlsException;

public class Main {
	
	public static void WriteToFile(ArrayList<Node> nodes) {
		try {
			FileOutputStream fileOut = new FileOutputStream("booktree.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			for (Node node : nodes) {
				objectOut.writeObject(node);
			}
			objectOut.close();
			System.out.println("Successfully written to file");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static ArrayList<Node> ReadFromFile() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Boolean cont = true;
		try {
			FileInputStream fi = new FileInputStream(new File("bookTree.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			while(cont) {
				Node n = (Node)oi.readObject();
				if(n != null) {
					nodes.add(n);
				}else {
					cont = false;
					oi.close();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nodes;	
	}
	
	
	public static void main(String[] args) {
		
		Parser p = new Parser();
		p.FillShelves();
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		while(p.ids.size() >0) {
			String name = p.ids.get(0);
			p.ids.remove(0);
			nodes.add(new Node(name, p.ids, p.shelves));
			System.out.println("Finished node: "+p.ids.size() );
		}
		WriteToFile(nodes);
		//ArrayList<Node> nodes = ReadFromFile();
		System.out.print("Read from file");
		
		Scanner bookScanner = new Scanner(System.in);
		System.out.println("Enter up to 2 books that you have liked to get a book reccomendation (space seperated): ");
		String books = bookScanner.nextLine();
		String[] booksArray = books.split(" ");
		//get the relevant rules
		ArrayList<String> possiblities = new ArrayList<String>(); 
		for (int i = 0; i < booksArray.length; i++) {
			for (Node node : nodes) {
				for(String rule: node.Rules) {
					String[] ruleBooks = rule.split(",");
					for(int j = 0; j < ruleBooks.length; j++) {
						if(booksArray[i].equals(ruleBooks[j])) {
							possiblities.add(rule);
						}
					}
				}
			}
		}
		
		//sort through the relevant rules to find the most helpful ones
		for (String rule : possiblities) {
			int count = 0;
			String[] ruleBooks = rule.split(",");
			for (int i = 0; i < ruleBooks.length; i++) {
				for (int j = 0; j < booksArray.length; j++) {
					if(booksArray[j].equals(ruleBooks[i])) {
						count++;
						j = booksArray.length;
					}
				}
			}
			if (count == booksArray.length&& count < ruleBooks.length ) {
				System.out.println(rule.toString());
			}

		}
}
}
