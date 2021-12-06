package adventOfCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Day5 extends FileReader {

	static File file = new File("AOC2018/2018day5.txt");
	static ArrayList<String> vals = new ArrayList<>();
	static String input = "";
	
	public static int part1(String str) {
		boolean match = true;
		
		while(match==true) {
			for (int i=0; i<str.length()-1; i++) {
				char char1 = str.charAt(i);
				char char2 = str.charAt(i+1);
				
				if(Math.abs(char1-char2)==32) { //capital and lowercase of same letter
					match = true;
					if(i==0) str=str.substring(2);
					else if (i>0) {
						str=str.substring(0,i) + str.substring(i+2);
					}
					else {
						str=str.substring(0,i-1);
					}
					break;
				}
				else match=false;
			}
		}
		return str.length();
	}
	
	public static int part2() {
		String sequence = input;
		ArrayList<Integer> vals = new ArrayList<>();
		
		for (int i=0; i<26; i++) {
			char charLetter = (char) (i+65); //uppercase
			char charLetter2 = (char) (i+65+32);//lowercase
			String letter1 = String.valueOf(charLetter); //uppercase
			String letter2 = String.valueOf(charLetter2); //lowercase
			String cur = sequence.replaceAll(letter1, "");
			cur = cur.replaceAll(letter2, "");
			vals.add(part1(cur));
		}

		return Collections.min(vals);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		input = readFileToString(file);
		System.out.println(part1(input));
		System.out.println(part2());
	}
}