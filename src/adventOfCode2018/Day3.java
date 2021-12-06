package adventOfCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day3 extends FileReader {

	static File file = new File("AOC2018/2018day3.txt");
	static ArrayList<String> vals = new ArrayList<>();
	static ArrayList<Integer> coords = new ArrayList<>();
	static int[][] grid = new int[1000][1000];
	
	public static int part1() {
		parseFile();
		return findArea();
	}
	
	public static int part2() {
		parseFile();
		findArea();
		return findArea2();
	}
	
	/**
	 * fills coordinates array; 
	 * pos x%4=1 --> leftX; pos x%4=2 --> rightX 
	 * pos x%4=1 --> topY; pos x%4=0 --> bottomY
	 */
	private static void parseFile() {
		for (String i : vals) {
			String leftX = regexSearch("\\d+,", i);
			String topY = regexSearch("\\d+:", i);
			String width = regexSearch("\\d+x", i);
			String length = regexSearch("x\\d+", i).substring(1);
			leftX = leftX.substring(0,leftX.length()-1);
			topY = topY.substring(0,topY.length()-1);
			width = width.substring(0,width.length()-1);
			
			coords.add(Integer.parseInt(leftX));
			coords.add(Integer.parseInt(leftX)+Integer.parseInt(width));
			coords.add(Integer.parseInt(topY));
			coords.add(Integer.parseInt(topY)+Integer.parseInt(length));
		}
	}

	private static int findArea() {
		int totalOverlap = 0;
		
		for (int i=0; i<coords.size(); i+=4) { //each rectangle
			for (int j=coords.get(i); j<coords.get(i+1); j++) { //all x-vals
				for (int k=coords.get(i+2); k<coords.get(i+3); k++) { //all y-vals
					if(grid[j][k]==0) grid[j][k]=1; //set to 1 if the square is filled
					else if(grid[j][k]==1) { //if already filled, add to total overlap
						grid[j][k]=2;
						totalOverlap++;
					}
				}
			}
		}
		return totalOverlap;
	}

	private static int findArea2() {
		int idNum = 0;
		
		for (int i=0; i<coords.size(); i+=4) { //each rectangle
			boolean overlap=false;
			rectangles:
			for (int j=coords.get(i); j<coords.get(i+1); j++) { //all x-vals
				for (int k=coords.get(i+2); k<coords.get(i+3); k++) { //all y-vals
					if(grid[j][k]==2) {
						overlap=true;
						break rectangles;
					}
				}
			}
			if(overlap==false) {
				idNum=i/4+1;
				break;
			}
		}
		return idNum;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
//		System.out.println(part1());
		System.out.println(part2());
	}
}