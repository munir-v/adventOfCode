package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

	static File file = new File("AOC/day1.txt");
	static ArrayList<Integer> values = new ArrayList<>();

	//read file to array
	public static void readFile() throws FileNotFoundException { 
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()) {
			int i = 0;
			int n = Integer.parseInt(in.nextLine());
			values.add(i,n);
			i++;
		}
		in.close();
	}

	//find product of 2 numbers that add to 2020
	public static int part1() {
		int retval = 0;
		for (int i=0; i<values.size(); i++) {
			for (int j=0; j<values.size(); j++) {
				int num1 = values.get(i); 
				int num2 = values.get(j);
				if(num1 + num2 == 2020) {
					retval = num1 * num2;
				}
			}
		}
		return retval;
	}
	
	//find product of 3 numbers that add to 2020
	public static int part2() {
		int retval = 0;
		for (int i=0; i<values.size(); i++) {
			for (int j=0; j<values.size(); j++) {
				for (int k=0; k<values.size(); k++) {
					int num1 = values.get(i); 
					int num2 = values.get(j);
					int num3 = values.get(k);
					if(num1 + num2 + num3 == 2020) {
						retval = num1 * num2 * num3;
					}
				}
			}
		}
		return retval;
	}
	
	public static void main(String[] args) throws FileNotFoundException  {
		readFile();
		System.out.println(part1());
		System.out.println(part2());
	}
}
