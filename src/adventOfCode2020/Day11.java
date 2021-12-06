package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day11 extends FileReader {

	static File file = new File("AOC/day11test.txt");
	static ArrayList<String> values = new ArrayList<>();
	static ArrayList<ArrayList<String>> main = new ArrayList<>();
	static ArrayList<ArrayList<String>> newVals = new ArrayList<>();
	
	private static int row = 0; 
	private static int column = 0;
	
	public static void make2D() { //make 2D arraylist with input 
		for (int i=0; i<values.size(); i++) {
			ArrayList<String> sub = new ArrayList<>();
			for (int j=0; j<values.get(0).length(); j++) {
				sub.add(values.get(i).substring(j,j+1));
			}
			main.add(sub);
		}
	}
	
	//returns true if all adjacent seats are empty
	public static boolean isEmpty() {
		boolean retval = false;
		int rowLength = main.size();
		int columnLength = main.get(0).size();
		
		//checks if all adjacent seat are . or L by iterating through all values
		for (int i=-1; i<=1; i++) {
			for (int j=-1; j<=1; j++) {
				int r = row+i;
				int c = column+j;
				
				if((r>=0 && r<rowLength) && (c>=0 && c<columnLength)) { //within range
					String current = main.get(r).get(c);
					if(current.equals(".") || current.equals("L")) {
						retval = true;
					}
					else {
						return false; //may be an issue?
					}
				}
			}
		}
		return retval;
	}
	
	//returns true if four or more seats adjacent are occupied
	public static boolean isOccupied() { 
		boolean retval = false;
		int rowLength = main.size();
		int columnLength = main.get(0).size();
		int numSeats = 0;
		
		//checks if all adjacent seat are . or L by iterating through all values
		for (int i=-1; i<=1; i++) {
			for (int j=-1; j<=1; j++) {
				int r = row+i;
				int c = column+j;
				
				if((r>=0 && r<rowLength) && (c>=0 && c<columnLength)) { //within range
					String current = main.get(r).get(c);
					if(current.equals("#")) {
						numSeats++;
					}
				}
				
				if(numSeats<4) { //wait until 4 or more seats before returning true
					retval = false;
				}
				else {
					return true;
				}
			}
		}
		return retval;
	}
	
	//returns true if values are same as in previous cycle
	public static boolean isUnchanged() { 
		boolean retval = false;
		if(newVals.equals(main)) {
			retval = true;
		}
		return retval;
	}
	
	public static void checkCurrent() {
		int rowLength = main.size();
		int columnLength = main.get(0).size();
		
		for (int i=0; i<rowLength; i++) {
			for (int j=0; j<columnLength; j++) {
				row = i;
				column = j;
				String current = main.get(i).get(j); //current seat
				
				if(current.equals("L") && isEmpty()) {
					//set current seat to occupied
					newVals.get(i).set(j,"#");
				}
				else if(current.equals("#") && isOccupied()) {
					//set current seat to empty
					newVals.get(i).set(j,"L");
				}
			}
		}
	}
	
	public static int cycle() {
		int retval = 0;
		int rowLength = main.size();
		int columnLength = main.get(0).size();
		
		if(isUnchanged()) {
			for (int i=0; i<rowLength; i++) { // check all seats for #
				for (int j=0; j<columnLength; j++) {
					String current = main.get(i).get(j);
					if(current.equals("#")) retval++;
				}
			}
		}
		else {
			newVals = main; //MAKE METHOD TO ADD ALL OLD ARRAY VALS TO NEW ARRAY
//			checkCurrent();
//			main = newVals; 
//			cycle();
		}
		return retval;
	}

	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,values);
		make2D();
		System.out.println(cycle());
	}
}
