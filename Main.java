import java.util.ArrayList;

import javax.naming.directory.InvalidSearchControlsException;

public class Main {
	

	
	
	public static void main(String[] args) {
		Parser p = new Parser();
		p.FillShelves();
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		while(p.ids.size() >0) {
			String name = p.ids.get(0);
			p.ids.remove(0);
			nodes.add(new Node(name, p.ids, p.shelves));
			
		}

		
		System.out.print("Test");
	}
	

}
