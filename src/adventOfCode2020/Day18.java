package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day18 extends FileReader {

	static File file = new File("AOC/day18test.txt");
	static ArrayList<String> values = new ArrayList<>();
	private static int total = 0;
	private static boolean inside = false;
	
	
	public static int findTotal(String input, int start) throws FileNotFoundException {
		int i = start;
		if(i==input.length()) { //if the end is reached
			return total;
		}
		char loc = input.charAt(i);
		
		System.out.println("loc: " + loc);
		System.out.println("total: " + total + "\n");
		
		
		if(i==0) { //first time used
			total = Character.getNumericValue(loc);
			findTotal(input,i+1);
		}
		else if(loc>='0' && loc<='9') {
			return Character.getNumericValue(loc);
		}
		else if(loc=='(') {
			findTotal(input,i+1);
		}
		else if(loc==')') {
			return total;
		}
		else if(loc == '+') {
			total += findTotal(input,i+1);
			findTotal(input,i+2);
		}
		else if(loc == '*') {
			total *= findTotal(input,i+1);
			findTotal(input,i+2);
		}
		
		return total;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String input = readFileToString(file).replaceAll(" ", "");
		System.out.println("input: " + input + "\n");
		System.out.println(findTotal(input,0));
		
	}
}
