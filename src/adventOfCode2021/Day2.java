package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day2 extends FileReader {

	static File file = new File("AOC2021/day2.txt");	
	static ArrayList<String> vals = new ArrayList<>();
	
	public static int part1() {
		int horz = 0;
		int depth = 0;
		for (int i=0; i<vals.size(); i++) {
			String cur = vals.get(i);
			char direction = cur.charAt(0);
			int distance = Integer.parseInt(cur.substring(cur.length()-1));
			if(direction=='f') horz+=distance;
			else if(direction=='d') depth+=distance;
			else depth-=distance;
		}
		
		return horz*depth;
	}
	
	public static int part2() {
		int horz = 0;
		int depth = 0;
		int aim = 0;
		for (int i=0; i<vals.size(); i++) {
			String cur = vals.get(i);
			char direction = cur.charAt(0);
			int distance = Integer.parseInt(cur.substring(cur.length()-1));
			if(direction=='f') {
				horz+=distance;
				depth+=aim*distance;
			}
			else if(direction=='d') aim+=distance;
			else aim-=distance;
		}
		
		return horz*depth;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
		System.out.println(part1());
		System.out.println(part2());
		
	}
}