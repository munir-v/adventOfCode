package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {

	//read file to array where each line is a new string in the array
	public static void readFile(File file, ArrayList<String> values) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()) {
			String n = in.nextLine();
			values.add(n);
		}
		in.close();
	}
	
	//reads file to single string, returns the string
	public static String readFileToString(File file) throws FileNotFoundException {
		String retVal = "";
		Scanner in = new Scanner(file);
	
	    while (in.hasNextLine()) {
	    	retVal+= in.nextLine();
	    }   
	    in.close();
		
		return retVal;
	}
	
	//read file to array where each line is a new int in the array
	public static void readFileInt(File file, ArrayList<Integer> values) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()) {
			int n = in.nextInt();
			values.add(n);
		}
		in.close();
	}
	
	public static String regexSearch(String regex, String input){
		String str = "";
		Pattern checkRegex = Pattern. compile(regex);
		Matcher regexMatcher = checkRegex.matcher(input);
		
		while(regexMatcher.find()) {
			if(regexMatcher.group().length() != 0) {
				str = regexMatcher.group();
			}
		}
		return str;
	}
}
