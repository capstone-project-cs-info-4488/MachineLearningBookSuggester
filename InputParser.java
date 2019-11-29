public class InputParser {
	String[] inputBooks; 
	public InputParser(String input) {
		try {
			String[] books = input.split(",");
			inputBooks = books;
		}
		catch(Exception e) {
			System.out.println("Unable to parse input");
		}
	}
	
}
