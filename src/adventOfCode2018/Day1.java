package adventOfCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day1 extends FileReader {

	static File file = new File("AOC2018/2018day1.txt");
	static ArrayList<String> vals = new ArrayList<>();
	
	//part 1 - return sum of inputs
	public static int sum() {
		int retval = 0;
		for (int i=0; i<vals.size(); i++) {
			retval+=Integer.parseInt(vals.get(i));
		}

		return retval;
	}
	
	//part 2
	public static int sum2() {
		int retval = 0;
		boolean done = false;
		ArrayList<Integer> sums = new ArrayList<>();
		
		while(!done) {
			for (int i=0; i<vals.size(); i++) {
				int cur = Integer.parseInt(vals.get(i));
				retval+=cur;
	
				if(!sums.contains(retval)) sums.add(retval);
				else {
					done = true;
					break;
				}
			}
		}
		return retval;
	} 
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
//		System.out.println(sum());
		System.out.println(sum2());
		
	}
}