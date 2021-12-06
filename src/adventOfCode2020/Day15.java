package adventOfCode2020;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day15 {

	static ArrayList<Integer> values = new ArrayList<>(Arrays.asList(15,12,0,14,3,1));
//	static ArrayList<Integer> values = new ArrayList<>(Arrays.asList(0,3,6)); //test - 436
	
	public static int findNum(int locToFind) {
		int startPos = values.size()-1;
		for (int i=startPos; i<locToFind+1; i++) {
			int var = values.get(i);

			if(! appearsInList(var)) {
				values.add(0);
			}
			
			else {
				int diff = -1;
				for (int j=values.size()-2; j>=0; j--) {
					if(values.get(j) == var) {
						diff = i+1 - j-1;
						break;
					}
				}
				values.add(diff); //num of turns apart
			}
		}
		return values.get(locToFind-1);
	}
	
	
	//returns true if toCheck appears in the arraylist values
	private static boolean appearsInList(int toCheck) { 
		boolean retval = false;
		int numOfLocs = 0;
		for (int i=0; i<values.size(); i++) {
			if(values.get(i) == toCheck) numOfLocs++;
		}
		if(numOfLocs>1) retval = true;

//		int numOfLocs = Collections.frequency(values, toCheck);
//		if(numOfLocs>1) retval = true;
		
		return retval;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		System.out.println(findNum(2020)); //part 1
		System.out.println("operation took " + (System.currentTimeMillis() - start) + "milliseconds");

	}
}
