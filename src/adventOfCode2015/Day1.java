package adventOfCode2015;

import java.io.File;
import java.io.FileNotFoundException;

import adventOfCode2020.FileReader;

public class Day1 extends FileReader {

	static File file = new File("AOC15/day1.txt");
	static int floor = 0;
	
	public static int test() throws FileNotFoundException {
		int retval = 0;
		String input = readFileToString(file);
		
		for (int i=0; i<input.length(); i++) {
			if(input.charAt(i) == '(') floor++;
			else floor--;
			if(floor<0) {
				retval = i+1;
				break;
			}
		}
		return retval;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(test());
	}
}
