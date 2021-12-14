package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day6 extends FileReader {

	static File file = new File("AOC2021/day6.txt");	
	static ArrayList<Integer> vals = new ArrayList<>();
	static String input;
	
	//read file to array
	private static void readString() {
		String[] values = input.split(",");
		for (String s : values) {
			vals.add(Integer.parseInt(s));
		}

	}
	
	//find total # of fish
	public static int part1() {
		readString(); 

		for (int i=0; i<80; i++) {
			int max = vals.size();
			for (int j=0; j<max; j++) {
				int cur = vals.get(j);
				if(cur==0) {
					vals.set(j,6);
					vals.add(8);
				}
				else vals.set(j,cur-1);
			}
		}

		return vals.size();
	}
	
	public static void part2() {
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		input = readFileToString(file);
		System.out.println(part1());
		part2();
		
	}
}