package adventOfCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day4 extends FileReader {

	static File file = new File("AOC2018/2018day4.txt");
	static ArrayList<String> vals = new ArrayList<>();
	
	public static void part1() {
		java.util.Collections.sort(vals);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
		part1();
//		[1518-07-29 00:58] wakes up
//		[1518-03-18 00:15] falls asleep
//		[1518-11-08 00:02] Guard #2851 begins shift
		
	}
}