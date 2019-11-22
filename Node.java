import java.util.ArrayList;

public class Node implements Cloneable {
	Node Parent;
	ArrayList<Node> Children = new ArrayList<Node>();
	String Name;
	ArrayList<String> Ids;
	ArrayList<String[]> Shelves;
	double Support;
	double Confidence;
	
	
//	 public Object clone() throws CloneNotSupportedException {
//		    return super.clone();
//	 }
	public Node(String name, ArrayList<String> ids,ArrayList<String[]> shelves) {
		Parent = null;
		Ids = (ArrayList<String>)ids.clone();
		Shelves = (ArrayList<String[]>)shelves.clone();
		Name = name;
		int xcount = FindXCount();
		int[] commonIds = FindCommonIDs();
		FindAssociations(xcount, commonIds);
		Prune(commonIds);
	}
	public Node(String name, ArrayList<String> ids,ArrayList<String[]> shelves, double support, Node parent) {
		Ids = (ArrayList<String>)ids.clone();
		Shelves = (ArrayList<String[]>)shelves.clone();
		Name = name;
		//The first id is the current id, doesn't need to be included
		int idToRemove = ids.indexOf(Name);
		if(idToRemove != -1) {
			Ids.remove(idToRemove);
		}
		Support = support;
		Parent = parent;
		int xcount = FindXCount();
		int[] commonIds = FindCommonIDs();
		FindAssociations(xcount, commonIds);
		Prune(commonIds);
	}
	
	//Finds how many times a the book appears in the dataset
	private int FindXCount() {
		int count = 0;
		for (int j = 0; j < Shelves.size(); j++) {
			for (int j2 = 0; j2 < Shelves.get(j).length; j2++) {
				if(Shelves.get(j)[j2].contains(Name)) {
					count++;
				}
			}
		}
		return count;
	}
	
	//Builds the tree
	private void FindAssociations(int xCount, int[] commonIds) {		
		for (int i = 0; i < Ids.size(); i++) {
			int count = 0;
			for (int j = 0; j < commonIds.length; j++) {
				for (int j2 = 0; j2 < Shelves.get(commonIds[j]).length; j2++) {
					if(Shelves.get(commonIds[j])[j2].contains(Ids.get(i))) {
						count++;
					}
				}
			}
			ArrayList<String> ids2 = (ArrayList<String>)Ids.clone();
			ids2.remove(i);
			Children.add(new Node(Ids.get(i), ids2, Shelves, Support(count), this));
		}
		
	}
	
	
	private int FindLevels() {
		int count = 0;
		try {
			if(Parent != null) {
				Node p = (Node)Parent.clone();
				while(p.Parent != null) {
					count++;
					p = p.Parent;
				}
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//finds the relevant shelves
	//Needs to be modified to include the parents
	public int[] FindCommonIDs() {
		ArrayList<Integer> returnIds = new ArrayList<Integer>();
		
		for (int i = 0; i < Shelves.size(); i++) {
			for (int j = 0; j < Shelves.get(i).length; j++) {

				if(Shelves.get(i)[j].contains(Name)) {
					int levels = FindLevels();
					int count = 0;
					Node p;
					try {
						if(Parent != null) {
							p = (Node)Parent.clone();
							Boolean keepGoing = true;
							while(p.Parent != null && keepGoing == true) {
								Boolean found = false;
								int[] parentIds = p.FindCommonIDs();
								for (int k = 0; k < parentIds.length; k++) {
									if(parentIds[k] == i) {
										found = true;
									}
								}
								p = p.Parent;
								
								if(found == false) {
									keepGoing = false;
								}else {
									count++;
								}
							}
							if(count == levels) {
								returnIds.add(i);
							}
						}else {
							returnIds.add(i);
						}
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					 
				}

			}
		}
		int[] id = new int[returnIds.size()];
		for (int i = 0; i < returnIds.size(); i++) {
			id[i]= returnIds.get(i);
		}
		return id;
	}

	//Prunes the tree
	public void Prune(int[] commonIds) {
		for (int i = 0; i < Children.size(); i++) {
			if(Children.get(i).Support < .3) { 
				Children.remove(i);
				i--;
			}
		}

	}
	
	
	public double Confidence(int count, int xCount) {
		return (double)count/(double)xCount;
	}
	
	public double Support(int count) {
		int size = Shelves.size();
		double num = (double)count/(double)size;
		return num;
	}
}
