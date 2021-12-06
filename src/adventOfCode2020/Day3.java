package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;

public class Day3 extends FileReader {

	static File file = new File("AOC/day3.txt");
//	static File file = new File("AOC/day3 test.txt");
	static ArrayList<String> values = new ArrayList<>();
	
	public static int countTrees(int run, int rise) {
		int numTrees = 0;
		int slide = run;
		int length = values.get(0).length();
		
		for (int i=rise; i<values.size(); i+=rise) {
			if(slide > length-1) slide %= length;

			if(values.get(i).charAt(slide) == '#') { 
				numTrees++;
			}
			slide += run;
		}
		return numTrees;
	}
	
	public static BigInteger moreTrees() {
		String value1 = countTrees(1,1) + "";
		String value2 = countTrees(3,1) + "";
		String value3 = countTrees(5,1) + "";
		String value4 = countTrees(7,1) + "";
		String value5 = countTrees(1,2) + "";
        BigInteger a = new BigInteger(value1);
        BigInteger b = new BigInteger(value2);
        BigInteger c = new BigInteger(value3);
        BigInteger d = new BigInteger(value4);
        BigInteger e = new BigInteger(value5);
        
        BigInteger output = a.multiply(b).multiply(c).multiply(d).multiply(e);
		return output; 
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file, values);
		System.out.println(countTrees(3,1)); //part 1
//		System.out.println(moreTrees()); //part 2
	}
}
