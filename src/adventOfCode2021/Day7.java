package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Day7 extends FileReader {

	static File file = new File("AOC2021/day7.txt");	
	static ArrayList<String> vals = new ArrayList<>();
	static String val = "";
	
	public static int part1() {
		String[] vals = val.split(",");
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i=0; i<vals.length; i++) { //convert string[] input to ints
			nums.add(Integer.parseInt(vals[i]));
		}
		
		int maxVal = Collections.max(nums);
		
		ArrayList<Integer> fuelVals = new ArrayList<>();
		for (int i=0; i<maxVal; i++) { //for each distance to test
			int totalDistance = 0;
			for (int j=0; j<nums.size(); j++) { //for each crab
				totalDistance+=Math.abs((nums.get(j)-i));
			}
			fuelVals.add(totalDistance);
		}
		return Collections.min(fuelVals);
	}
	
	public static void part2() {
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		val = readFileToString(file);
		System.out.println(part1());
		part2();
		
	}
}