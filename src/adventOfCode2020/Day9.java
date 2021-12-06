package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day9 extends FileReader {

	static File file = new File("AOC/day9.txt");
	static List<BigInteger> list = new ArrayList<BigInteger>();
	static BigInteger invalidNum = new BigInteger("257342611"); //set equal to result of part 1
	private static int curLoc = 0;
	private static int beginIndex = 0;
	private static int endIndex = 0;
	
	public static void readFileInt(File file, List<BigInteger> list) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		while(in.hasNextLine()) {
			BigInteger n = new BigInteger(in.nextLine());
			list.add(n);
		}
		in.close();
	}
	
	//returns true if 26th num is sum of any two from previous 25 (or other preamble) nums
	private static boolean test(int preamble) {
		boolean retval = true;
		
		for (int i=curLoc; i<curLoc+preamble-1; i++) {
			for (int j=i+1; j<preamble+curLoc; j++) {
				BigInteger num1 = list.get(i); 
				BigInteger num2 = list.get(j);
				if(num1.add(num2).equals(list.get(curLoc+preamble))) return true;
				else retval = false;
			}
		}
		return retval;
	}
	
	public static BigInteger findWrongSum(int preamble) { //part 1
		while(test(preamble) == true) curLoc++;
		return list.get(curLoc+preamble);
	}
	
	private static boolean test2(BigInteger invalidNum) {
		boolean retval = false;
		BigInteger sum = new BigInteger("0");

		for (int i=curLoc; i<list.size(); i++) {
			for (int j=i; j<list.size(); j++) {
				beginIndex = i;
				if(sum.compareTo(invalidNum) > 0) { //if sum exceeds invalidNum
					retval = false;
					sum = new BigInteger("0");
					break;
				}
				sum = sum.add(list.get(j));

				if(sum.equals(invalidNum)) {
					endIndex = j+1;
					return true;
				}
				else retval = false;
			}
		}
		return retval;
	}
	
	public static BigInteger findNewSum(BigInteger invalidNum) { //part 2
		while(test2(invalidNum) == false) curLoc++;
		
		//find lowest and highest value in range
		List<BigInteger> values = new ArrayList<BigInteger>();
		for (int i=0; i<endIndex-beginIndex; i++) {
			values.add(list.get(beginIndex+i));
		}
		
		BigInteger max = new BigInteger("0");
		max = Collections.max(values);
		BigInteger min = new BigInteger("0");
		min = Collections.min(values);
		
		return max.add(min);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFileInt(file,list);
//		System.out.println("Result: " + findWrongSum(25)); //part 1
		System.out.println("Result: " + findNewSum(invalidNum)); //part 1
	}
}
