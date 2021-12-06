package adventOfCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day2 extends FileReader {

	static File file = new File("AOC2018/2018day2.txt");
	static ArrayList<String> vals = new ArrayList<>();

	public static int findSums() {
		int twoCount = 0;
		int threeCount = 0;
		for (int i=0; i<vals.size(); i++) { //for each string in list
			ArrayList<String> chars = new ArrayList<>();
			String cur = vals.get(i);
			boolean two = false; //keep track of if two chars repeat
			boolean three = false;
			
			for (int j=0; j<cur.length(); j++) { //for each char in string
				int count = 1; //how many times a letter appears
				String charCur = cur.substring(j,j+1);
				if(!chars.contains(charCur)) {
					for (int k=j; k<cur.length()-1; k++) {
						if(cur.substring(k+1,k+2).equals(charCur)) count++;
					}
					chars.add(charCur);
				}
				if(count==2) two=true; 
				else if(count==3) three=true;
			}
			if(two) twoCount++; 
			if(three) threeCount++;
		}
		return twoCount*threeCount;
	}
	
	public static void part2() {
		for (int i=0; i<vals.size()-1; i++) { //for each string
			String cur = vals.get(i);
			
			//for each of the following strings
			for (int j=i+1; j<vals.size(); j++) { 
				String next = vals.get(j);
				int diffCount = 0; //num of different letters
				boolean match = true;
				for (int k=0; k<cur.length(); k++) {
					if(cur.charAt(k) != next.charAt(k)) {
						diffCount++;
					}
					if(diffCount==2) {
						match=false;
						break;
					}
				}
				if(match==true) {
					System.out.println(findNewString(cur,next));
				}
			}
		}
	}
	
	private static String findNewString(String str1, String str2) {
		String retval = "";
		int split = 0;
		
		for (int i=0; i<str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				split=i;
				break;
			}
		}
		retval=str1.substring(0,split)+str1.substring(split+1);
		
		return retval;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
		System.out.println(findSums()); //part 1
		part2(); //part 2 
		 
	} 
}