package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day8 extends FileReader {

	static File file = new File("AOC/day8.txt");
	static ArrayList<String> values = new ArrayList<>();
	static ArrayList<Integer> cache = new ArrayList<>();
	
	private static int location = 0; //for main methods
	private static int currentLoc = 0; //for flipping values
	private static int prevLoc = -1; //for flipping values
	private static int acc = 0;
	
	public static int part1() {
		while(previousLoc() != true) {
			cache.add(location);
			
			String current = values.get(location);
			
			if(current.contains("acc")) {
				int add = Integer.parseInt(current.substring(5));
				if(current.charAt(4) == '+') acc+=add;
				else acc-=add;
				location++;
			}
			else if(current.contains("jmp")) {
				int add = Integer.parseInt(current.substring(5));
				if(current.charAt(4) == '+') location+=add;
				else location-=add;
			}
			else location++; //nop
		}
		return acc;
	}
	
	private static boolean previousLoc() { //returns true if the location has been visited before
		boolean retval = false;
		for (int j=0; j<cache.size(); j++) { //check if instruction has been done before
			if(cache.get(j) == location) {
				retval = true; 
				break;
			}
		}
		return retval;
	}
	
	public static int part2() {
		if(repeats()) {
			acc=0;
			location=0;
			
			System.out.println("values: " + values);
			
			flipNext();
			part2();
		}
		else {
			System.out.println("GOOD");
		}
		return acc;
	}
	
	public static boolean repeats() {
		boolean retval = true;
		cache.clear();
		
		while(previousLoc() != true) {
			if(location >= values.size()) {
				retval = false;
				break;
			}
			
			cache.add(location);
			
			String current = values.get(location);
			
			if(current.contains("acc")) {
				int add = Integer.parseInt(current.substring(5));
				if(current.charAt(4) == '+') acc+=add;
				else acc-=add;
				location++;
			}
			else if(current.contains("jmp")) {
				int add = Integer.parseInt(current.substring(5));
				if(current.charAt(4) == '+') location+=add;
				else location-=add;
			}
			else location++; //nop
		}
		return retval;
	}
	
	private static void flipNext() {
		String current = values.get(currentLoc);
		
		if(prevLoc != -1) { //skip first time method is called
			//"fix" last modification before making new one below
			if(current.contains("nop")) values.set(prevLoc, "jmp" + current.substring(3));
			else values.set(prevLoc, "nop" + current.substring(3));
			currentLoc++; //check from the next location 
		}
		
		current = values.get(currentLoc);
		while(current.contains("acc")) {
			currentLoc++;
			if(currentLoc>=values.size()) {
				System.out.println("STOP");
				part2();
			}
			current = values.get(currentLoc);
		}
		
		//replace nop with jmp and vice versa
		if(current.contains("nop")) values.set(currentLoc, "jmp" + current.substring(3));
		else values.set(currentLoc, "nop" + current.substring(3));
		
		prevLoc = currentLoc;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,values);
//		System.out.println(part1());
		System.out.println(part2());
	}
}
