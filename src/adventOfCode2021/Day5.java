package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day5 extends FileReader {

	static File file = new File("AOC2021/day5.txt");	
	static ArrayList<String> vals = new ArrayList<>();
	static ArrayList<Integer> coords = new ArrayList<>();
	static int[][] grid = new int[1000][1000];
	
	public static void part1() {
		parseFile();
		
	}
	
	public static void part2() {
		
		
	}
	
	private static void parseFile() {
		for (String i : vals) {
			String[] xy1 = i.split(" -> ",-1);
			String[] xy2 = xy1.split(",",-1);
			String[] xy3 = xy1.split(",",-1);
			String y1 = regexSearch("^\\d+,(\\d+)", i);
			String x2 = regexSearch("> (\\d+)", i);
			String y2 = regexSearch("> \\d+,(\\d+)", i).substring(1);
			
			coords.add(Integer.parseInt(x1));
			coords.add(Integer.parseInt(x2));
			coords.add(Integer.parseInt(y1));
			coords.add(Integer.parseInt(y2));
		}
		System.out.println("coords: " + coords);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
		part1();
		part2();
		
	}
}