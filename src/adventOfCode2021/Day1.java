package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day1 extends FileReader {

	static File file = new File("AOC2021/day1.txt");
	static ArrayList<Integer> vals = new ArrayList<>();
	
	public static int part1() {
		int numIncreases=0;
		for (int i=1; i<vals.size(); i++) {
			if(vals.get(i)>vals.get(i-1)) numIncreases++;
		}

		return numIncreases;
	}
	
	public static int part2() {
		int numIncreases=0;
		for (int i=0; i<vals.size()-3; i++) {
			int cur = vals.get(i)+vals.get(i+1)+vals.get(i+2);
			int next = vals.get(i+1)+vals.get(i+2)+vals.get(i+3);
			if(next>cur) numIncreases++;
		}
		
		return numIncreases;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFileInt(file,vals);
		System.out.println(part1());
		System.out.println(part2());
		
	}
}