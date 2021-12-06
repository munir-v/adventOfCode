package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Day13 extends FileReader {

	static File file = new File("AOC/day13.txt");
	static List <String> values;
	
	private static int leaveTime = 1000508; //set equal to first line of input
	
	public static void inputToArray(File file) throws FileNotFoundException {
		String input = readFileToString(file);
		String[] myArray = input.split(",");
		values = Arrays.asList(myArray);
	}
	
	public static int getTime(int leaveTime) {
		int prevLow = -1;
		int stepVal = -1;
		
		for(String current : values) {
			if(! current.equals("x")) {
				int num = Integer.parseInt(current);
				int step = Integer.parseInt(current);
				
				while(num<leaveTime) num+=step;
				if(prevLow == -1) prevLow = num; //first time
				
				if(num<prevLow) {
					prevLow = num;
					stepVal = step;
				}
			}
		}
		return (prevLow - leaveTime) * stepVal;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		inputToArray(file);
		System.out.println(values);
		System.out.println(getTime(leaveTime)); //part 1
		
	}
}
