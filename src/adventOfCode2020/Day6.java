package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day6 extends FileReader {

	static File file = new File("AOC/day6.txt");
	static ArrayList<String> values = new ArrayList<>();
	static ArrayList<String> newVals = new ArrayList<>();

	
	public static int countUnique(String s) {
		s = s.replace(" ", "");
		char[] chars = s.toCharArray();
		Set<Character> uniqueChars = new HashSet<>();
		
		for (char c : chars) {
		   uniqueChars.add(c);
		}

		return uniqueChars.size();
	}

	//makes an array where a blank line from original list is separator for new list
	public static void makeList() {
		int lineCounter = 0;
		int arrayCounter = 0;

		for (int i=0; i<values.size(); i++) {
			if(values.get(i).matches("")) {
				String group = "";
				for (int j=lineCounter; j<i; j++) { //make a string with line
					group += values.get(j);
				}
				newVals.add(arrayCounter, group); //new array of single groups
				lineCounter = i;
				arrayCounter++;
			}
		}
		
		String group = "";
		for (int j=lineCounter; j<values.size(); j++) { //last group
			group += values.get(j);
		}
		newVals.add(arrayCounter, group); //last set
	}
	
	public static int findSum() { //part 1 - returns sum of unique answers from all groups
		makeList();
		int sum = 0;
		for (int i=0; i<newVals.size(); i++) {
			sum += countUnique(newVals.get(i));
		}
		return sum;
	}
	
	public static int findSum2() {
		int sum = 0;
		int start = 0;
		int end = 0;
		
		for (int i=0; i<values.size(); i++) {
			if(values.get(i).matches("")) {
				end = i;
				ArrayList<String> group = new ArrayList<>();
				
				for (int j=0; j<(end-start); j++) {
					group.add(values.get(start+j));
				}
				
				System.out.println("values: " + group);
				
				start = end+1;
				sum += checkGroups(group);
			}
		}
		
		ArrayList<String> group = new ArrayList<>();
		for (int j=0; j<values.size()-end-1; j++) { //last group
			group.add(values.get(start+j));
		}
		System.out.println("values: " + group);
		sum += checkGroups(group);
		
		return sum;
	}
	
	public static int checkGroups(ArrayList<String> group) { //part 2 - returns sum of common answers from each group
		int sum = 0;
		boolean retval = true;
		
		String line1 = group.get(0);
		for (int i=0; i<line1.length(); i++) { //check each letter in first line
			char line1Char = line1.charAt(i);
			
			for (int k=1; k<group.size(); k++) { //check each of the following lines
				String currentLine = group.get(k);
				//if the line1 char contains char in current line, move to the next line
				//else return false for line1char
				if(currentLine.indexOf(line1Char)>=0) {
					retval = true;
				}
				else {
					retval = false;
					break;
				}
			}
			//add to sum if line1 char found a match in every line
			if(retval == true) sum++;
		}
		return sum;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file, values);
//		System.out.println(findSum()); //part 1
		System.out.println(findSum2()); // part 2
	}
}
