package edu.isu.capstone.bookrec.recommender;

import java.io.Serializable;
import java.util.ArrayList;

public class Node implements Cloneable, Serializable{
	Node Parent;
	ArrayList<Node> Children = new ArrayList<Node>();
	String Name;
	ArrayList<String> Ids;
	ArrayList<String[]> Shelves;
	double Support;
	ArrayList<String> Rules = new ArrayList<String>();
	int Level;
	
	public Node(String name, ArrayList<String> ids,ArrayList<String[]> shelves) {
		Parent = null;
		Ids = (ArrayList<String>)ids.clone();
		Shelves = (ArrayList<String[]>)shelves.clone();
		Name = name;
		Level = 0;
		int xcount = FindXCount();
		int[] commonIds = FindCommonIDs();
		FindAssociations(xcount, commonIds);
		Prune(commonIds);
		MakeRules();
		
	}
	public Node(String name, ArrayList<String> ids,ArrayList<String[]> shelves, double support, Node parent, int level) {
		Ids = (ArrayList<String>)ids.clone();
		Shelves = (ArrayList<String[]>)shelves.clone();
		Name = name;
		Level = level;
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
	//want to build a tree only 3 levels deep
	private void FindAssociations(int xCount, int[] commonIds) {	
		for (int i = 0; i < Ids.size(); i++) {
			int count = 0;
			for (int j = 0; j < commonIds.length; j++) {
				for (int j2 = 0; j2 < Shelves.get(commonIds[j]).length; j2++) {
					if(Shelves.get(commonIds[j])[j2].equals(Ids.get(i))) {
						count++;
					}
				}
			}
			ArrayList<String> ids2 = (ArrayList<String>)Ids.clone();
			ids2.remove(i);
			if(Level +1 < 3) {
				//System.out.println(Level);
				Children.add(new Node(Ids.get(i), ids2, Shelves, Support(count), this, Level+1));
				
			}else {
				return;
			}
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
	//Still not working
	public int[] FindCommonIDs() {
		ArrayList<Integer> returnIds = new ArrayList<Integer>();
		
		for (int i = 0; i < Shelves.size(); i++) {
			for (int j = 0; j < Shelves.get(i).length; j++) {

				if(Shelves.get(i)[j].contains(Name)) {
					try {
						if(Parent != null) {
							Node p = (Node)Parent.clone();
							Boolean keepGoing = true;
							int count = 0;
							int levels = FindLevels();
							while(p.Parent != null && keepGoing == true) {
								Boolean found = false;
								int[] parentIds = p.FindCommonIDs();
								for (int k = 0; k < parentIds.length; k++) {
									if(parentIds[k] == j) {
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
						e.printStackTrace();
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
			if(Children.get(i).Support < .001) { 
				Children.remove(i);
				i--;
			}
		}

	}
	
	public void MakeRules() {
		//need to have a way to seperate each element of the rule, either by space or by comma or...
		MakeRulesInner(this, Name);
		FinishRules();
	}
	//adds the "beginning" parts of the rules
	private void FinishRules() {
		for (int i = 0; i < Rules.size(); i++) {
			String s = Rules.get(i);
			while(s.length() > 2) {
				s = s.substring(0, s.length()-1);
				Boolean addRule = true;
				for (int j = 0; j < Rules.size(); j++) {
					if(Rules.get(j).equals(s)) {
						addRule = false;
					}
				}
				if(addRule) {
					Rules.add(s);
				} 
			}
		}
	}

	//Makes the longest rules
	private String MakeRulesInner(Node node, String current) {
		String tempString = current;
		for (int i = 0; i < node.Children.size(); i++) {
			if(node.Children.get(i).Children.size()>0) {
				//keep going
				current = MakeRulesInner(node.Children.get(i), current);
				Boolean addRule = true;
				for (int j = 0; j < Rules.size(); j++) {
					if(Rules.get(j).contains(current)) {
						addRule = false;
					}
				}
				if(addRule) {
					Rules.add(current);
				}
				current = tempString;
			}else {
				//no reason to keep going down the tree
				return current+"," + node.Name+"," + node.Children.get(i).Name;
			}
		}
		return current+"," + node.Name;
	}
	
	public double Support(int count) {
		int size = Shelves.size();
		double num = (double)count/(double)size;
		return num;
	}
	

}
