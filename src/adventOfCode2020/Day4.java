package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day4 extends FileReader {

	static File file = new File("AOC/day4.txt");
	static ArrayList<String> values = new ArrayList<>();
	static ArrayList<String> newValues = new ArrayList<>();
	static ArrayList<String> new2 = new ArrayList<>();
	
	
	public static void makeList() {//makes an array with each passport
		int lineCounter = 0;
		int arrayCounter = 0;

		for (int i=0; i<values.size(); i++) {
			if(values.get(i).matches("")) {
				String passport = "";
				for (int j=lineCounter; j<i; j++) { //make a string with each passport
					passport += values.get(j);
				}
				newValues.add(arrayCounter, passport); //new array of single passports
				lineCounter = i;
				arrayCounter++;
			}
		}
		
		String passport = "";
		for (int j=lineCounter; j<values.size(); j++) { //last passport
			passport += values.get(j);
		}
		newValues.add(arrayCounter, passport); //last set
	}
	
	public static int checkValidPassports() { //part 1
		int validPassports = 0;
		
		for (int i=0; i<newValues.size(); i++) {
			if(hasKeywords(newValues.get(i))) {
				validPassports++;
				new2.add(newValues.get(i));
			}
		}
		return validPassports;
	}
	
	private static boolean hasKeywords(String str) {
		boolean retval = false;
		if(str.contains("byr") && str.contains("iyr") && str.contains("eyr") 
				&& str.contains("hgt") && str.contains("hcl") && str.contains("ecl") 
				&& str.contains("pid")) {
			retval = true;
		}
		return retval;
	}
	
	//7 valid conditions
	public static boolean case1(String str) {
		boolean retval = true;
		
		int var1 = str.indexOf("byr");
		int year = Integer.parseInt(str.substring(var1+4, var1+8));
		if(!(year>=1920 && year<=2002)) retval = false; 
		
		return retval;
	}
	
	public static boolean case2(String str) {
		boolean retval = true;
		
		int var2 = str.indexOf("iyr");
		int year = Integer.parseInt(str.substring(var2+4, var2+8));
		if(!(year>=2010 && year<=2020)) retval = false;
		
		return retval;
	}
	
	public static boolean case3(String str) {
		boolean retval = true;
		
		int var3 = str.indexOf("eyr");
		int year = Integer.parseInt(str.substring(var3+4, var3+8));
		if(!(year>=2020 && year<=2030)) retval = false;
		
		return retval;
	}
	
	public static boolean case4(String str) {
		boolean retval = true;
		
		int var4 = str.indexOf("hgt");
		String num = regexSearch("hgt:\\d+[ci]", str.substring(var4));
		
		String val = regexSearch("\\d+",num);
		if(val.length()<=0) return false;
		int height = Integer.parseInt(val);
			
		if(num.contains("c")) { //cm
			if(!(height>=150 && height<=193)) retval = false;
		}
		if(num.contains("i")) { //in
			if(!(height>=59 && height<=76)) retval = false;
		}
		
		return retval;
	}
	
	public static boolean case5(String str) {
		boolean retval = true;

		int var5 = str.indexOf("hcl");
		String value = str.substring(var5);
		
		String val = regexSearch("hcl:#[a-f0-9]{6}", value);
		if(val.length()<=0) return false;
		
		return retval;
	}
	
	public static boolean case6(String str) {
		boolean retval = true;
		
		int var6 = str.indexOf("ecl");
		String value = str.substring(var6+4,var6+7);
		if(!(value.matches("amb|blu|brn|gry|grn|hzl|oth"))) retval = false;
		
		return retval;
	}
	
	public static boolean case7(String str) {
		boolean retval = true;

		int var7 = str.indexOf("pid");
		String value = regexSearch("\\d{8}\\d+", str.substring(var7));
		if(value.length()<=0 || value.length()>=10) return false;
		
		int num = Integer.parseInt(value);
		if(!(num<1000000000)) retval = false;
		
		return retval;
	}
	
	public static int checkValidPassports2() { //part 2
		int validPassports = 0;

		for (int i=0; i<new2.size(); i++) {
			String current = new2.get(i);
		
			if(case1(current) && case2(current) && case3(current) && case4(current) && 
					case5(current) && case6(current) && case7(current)) {
				validPassports++;
			}
		}
		return validPassports;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,values);
		makeList();
		System.out.println(checkValidPassports()); //part1
		System.out.println("Valid passports: " + checkValidPassports2()); //part2
	}
}
