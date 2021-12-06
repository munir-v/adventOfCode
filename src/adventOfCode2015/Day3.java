package adventOfCode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import adventOfCode2020.FileReader;

public class Day3 extends FileReader {

	static File file = new File("AOC15/day3.txt");
	static ArrayList<Integer> values = new ArrayList<>();
	static ArrayList<Integer> values1 = new ArrayList<>();
	static ArrayList<Integer> values2 = new ArrayList<>();
	static int xDist = 0;
	static int yDist = 0;
	static int xDist1 = 0;
	static int yDist1 = 0;
	static int xDist2 = 0;
	static int yDist2 = 0;
	
	public static int findHouses() throws FileNotFoundException {
		int retval = 0;
		String input = readFileToString(file);
		
		for (int i=0; i<input.length(); i++) {
			char move = input.charAt(i);
			
			switch(move) {
				case '>':
					xDist++;
					break;
				case 'v':
					yDist--;
					break;
				case '<':
					xDist--;
					break;
				case '^':
					yDist++;
					break;
				default:
					System.out.println("ERROR");
					break;
			}
			values.add(xDist);
			values.add(yDist);
			if(houseIsUnique()) retval++;
		}
		values.clear();
		return retval;
	}
	
	private static boolean houseIsUnique() {
		boolean retval = true;
		int length = values.size();
		
		for (int i=0; i<length -2; i+=2) {
			int lastX = values.get(length-2);
			int lastY = values.get(length-1);
			
			if(values.get(i)==lastX && values.get(i+1)==lastY) {
				retval = false;
				break;
			}
		}

		return retval;
	}
	
	private static int houses1() throws FileNotFoundException {
		int retval = 0;
		String input = readFileToString(file);
		
		for (int i=0; i<input.length(); i+=2) {
			char move = input.charAt(i);
			
			switch(move) {
				case '>':
					xDist1++;
					break;
				case 'v':
					yDist1--;
					break;
				case '<':
					xDist1--;
					break;
				case '^':
					yDist1++;
					break;
				default:
					System.out.println("ERROR");
					break;
			}
			values.add(xDist1);
			values.add(yDist1);
			if(houseIsUnique()) retval++;
		}
		return retval;
	}
	
	private static int houses2() throws FileNotFoundException {
		int retval = 0;
		String input = readFileToString(file);
		
		for (int i=1; i<input.length(); i+=2) {
			char move = input.charAt(i);
			
			switch(move) {
				case '>':
					xDist2++;
					break;
				case 'v':
					yDist2--;
					break;
				case '<':
					xDist2--;
					break;
				case '^':
					yDist2++;
					break;
				default:
					System.out.println("ERROR");
					break;
			}
			values.add(xDist2);
			values.add(yDist2);
			if(houseIsUnique()) retval++;
		}
		return retval;
	}
	
	public static int findHouses2() throws FileNotFoundException {
		return houses1() + houses2();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(findHouses()); //part1
		System.out.println(findHouses2()); //part2
	}
}
