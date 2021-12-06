package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day3 extends FileReader {

	static File file = new File("AOC2021/day3.txt");	
	static ArrayList<String> vals = new ArrayList<>();
	
	public static int part1() {
		int gamma = 0;
		int epsilon = 0;
		String gammaStr = "";
		String epsilonStr = "";
		
		for (int i=0; i<vals.get(0).length(); i++) {
			int zeroCount=0;
			
			for (int j=0; j<vals.size(); j++) {
				int num = Integer.parseInt(vals.get(j).substring(i,i+1));
				if(num==0) zeroCount++;
			}
			if(zeroCount<vals.size()/2) {
				gammaStr+="0";
				epsilonStr+="1";
			}
			else {
				gammaStr+="1";
				epsilonStr+="0";
			}
		}
		gamma = Integer.parseInt(gammaStr,2);
		epsilon = Integer.parseInt(epsilonStr,2);
		return gamma*epsilon;
	}
	
	public static void part2() {
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
		System.out.println(part1());
		part2();
		
	}
}