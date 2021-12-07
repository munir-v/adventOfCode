package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day3 extends FileReader {

	static File file = new File("AOC2021/day3.txt");	
	static ArrayList<String> vals = new ArrayList<>();
	static ArrayList<String> oxVals = new ArrayList<>();
	static ArrayList<String> co2Vals = new ArrayList<>();
	
	public static int part1() {
		int gamma = 0;
		int epsilon = 0;
		String gammaStr = "";
		String epsilonStr = "";
		
		//for the length of the terms (each row)
		for (int i=0; i<vals.get(0).length(); i++) { 
			int zeroCount=0;
			
			//for the size of the array (each column)
			for (int j=0; j<vals.size(); j++) {
				int bit = Integer.parseInt(vals.get(j).substring(i,i+1)); //single bit
				if(bit==0) zeroCount++; //increase if the current bit is zero
			}
			//if the majority of bits in a column are zero
			if(zeroCount<vals.size()/2) {  
				gammaStr+="0";
				epsilonStr+="1";
			}
			else {
				gammaStr+="1";
				epsilonStr+="0";
			}
		}
		gamma = Integer.parseInt(gammaStr,2); //convert to decimal
		epsilon = Integer.parseInt(epsilonStr,2);
		return gamma*epsilon;
	}
	
	private static int findOxygen() {
		int retval = -1;
	
		//for the length of the terms (each row)
		for (int i=0; i<oxVals.get(0).length(); i++) {
			if(oxVals.size()==1) break;
			int mostCommon = 0; //most common bit per column
			int zeroCount=0;
			
			//for each column
			for (int j=0; j<oxVals.size(); j++) {
				int bit = Integer.parseInt(oxVals.get(j).substring(i,i+1));
				if(bit==0) zeroCount++;
			}
			//if the majority of bits in a column are not zero
			if(!(zeroCount>oxVals.size()/2)) { 
				mostCommon = 1; 
			}
			
			for (int j=oxVals.size()-1; j>=0; j--) { //for each column
				int bit = Integer.parseInt(oxVals.get(j).substring(i,i+1)); //single bit
				if(bit!=mostCommon) oxVals.remove(j); //remove terms if they aren't most common bit 
			}
		}
		retval = Integer.parseInt(oxVals.get(0),2); //convert to decimal
		return retval;
	}
	
	private static int findCO2() {
		int retval = -1;
		//for the length of the terms (each row)
		for (int i=0; i<co2Vals.get(0).length(); i++) {
			if(co2Vals.size()==1) break;
			int mostCommon = 1; //most common bit per column
			int zeroCount=0;
			
			//for each column
			for (int j=0; j<co2Vals.size(); j++) {
				int bit = Integer.parseInt(co2Vals.get(j).substring(i,i+1));
				if(bit==0) zeroCount++;
			}
			//if the majority of bits in a column are not zero
			if(!(zeroCount>co2Vals.size()/2)) { 
				mostCommon = 0; 
			}
			
			for (int j=co2Vals.size()-1; j>=0; j--) { //for each column
				int bit = Integer.parseInt(co2Vals.get(j).substring(i,i+1)); //single bit
				if(bit!=mostCommon) co2Vals.remove(j);
			}
		}
		retval = Integer.parseInt(co2Vals.get(0),2); 
		return retval;
	}
	
	public static int part2() {
		return findOxygen()*findCO2();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
		readFile(file,oxVals);
		readFile(file,co2Vals);
		System.out.println(part1());
		System.out.println(part2());
		
	}
}