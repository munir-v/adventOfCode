package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day5 extends FileReader {

	static File file = new File("AOC2021/day5.txt");	
	static ArrayList<String> vals = new ArrayList<>();
	static ArrayList<Integer> coords = new ArrayList<>();
	static int[][] grid = new int[1000][1000];
	
	public static int part1() {
		parseFile();
		return findOverlap1();
	}
	
	public static int part2() {
		parseFile();
		return findOverlap2();
	}
	
	private static void parseFile() {
		for (String i : vals) {
			String[] values = i.split(" -> |,");
			for (String j : values) {
				coords.add(Integer.parseInt(j));
			}
		}
		System.out.println("coords: " + coords);
	}
	
	private static int findOverlap1() {
		int totalOverlap = 0;
		
		for (int i=0; i<coords.size(); i+=4) { //each coord set
			int x1 = coords.get(i);
			int x2 = coords.get(i+2);
			int y1 = coords.get(i+1);
			int y2 = coords.get(i+3);
			int start = 0;
			int end = 0;
			
			if(x1==x2) {
				if(y2>y1) {
					start = y1;
					end = y2;
				}
				else {
					end = y1;
					start = y2;
				}
				for (int j=start; j<=end; j++) {
					if(grid[x1][j]==0) grid[x1][j]=1; //set to 1 if the square isn't filled
					else if(grid[x1][j]==1) { //if already filled, add to total overlap
						grid[x1][j]=2;
						totalOverlap++;
					}
				}
			}
			else if(y1==y2) {
				if(x2>x1) {
					start = x1;
					end = x2;
				}
				else {
					end = x1;
					start = x2;
				}
				for (int j=start; j<=end; j++) {
					if(grid[j][y1]==0) grid[j][y1]=1; //set to 1 if the square isn't filled
					else if(grid[j][y1]==1) { //if already filled, add to total overlap
						grid[j][y1]=2;
						totalOverlap++;
					}
				}
			}
		}

		return totalOverlap;
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
//		System.out.println(part1());
		System.out.println(part2());
		
	}
}