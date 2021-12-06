package adventOfCode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import adventOfCode2020.FileReader;

public class Day2 extends FileReader {

	static File file = new File("AOC15/day2.txt");
	static ArrayList<String> values = new ArrayList<>();
	static ArrayList<Integer> current = new ArrayList<>();
	
	public static int findPaper() {
		int retval = 0;
		
		for (int i=0; i<values.size(); i++) {
			String dimensions = values.get(i);
			String[] vals = dimensions.split("x");
			for(String var : vals) {
				current.add(Integer.parseInt(var));
			}
			Collections.sort(current);
			int l = current.get(0);
			int w = current.get(1);
			int h = current.get(2);
			
			retval += 2*(l*w + w*h + h*l) + l*w;
			current.clear();
		}

		
		return retval;
	}
	
	public static int findRibbon() {
		int retval = 0;
		
		for (int i=0; i<values.size(); i++) {
			String dimensions = values.get(i);
			String[] vals = dimensions.split("x");
			for(String var : vals) {
				current.add(Integer.parseInt(var));
			}
			Collections.sort(current);
			int l = current.get(0);
			int w = current.get(1);
			int h = current.get(2);
			
			retval += 2*(l+w) + l*w*h;
			current.clear();
		}
		
		return retval;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,values);
		System.out.println(findPaper()); //part1
		System.out.println(findRibbon()); //part2
		
	}
}
