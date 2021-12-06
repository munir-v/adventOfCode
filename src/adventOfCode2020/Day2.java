package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {

	static File file = new File("AOC/day2.txt");
	static ArrayList<String> values = new ArrayList<>();
	private static int validPasswords;

	public static void readFile() throws FileNotFoundException { //read file to array
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()) {
			String n = in.nextLine();
			values.add(n);
		}
		in.close();
	}
	
	public static int findValidPasswords() {
		for (int i=0; i<values.size(); i++) {
			String current = values.get(i);
			
			int dashLoc = charLoc(current,"-");
			int spaceLoc = charLoc(current," ");
			int colonLoc = charLoc(current,":");
			
			String min = current.substring(0,dashLoc);
			String max = current.substring(dashLoc+1,spaceLoc);
			int smallestNum = Integer.parseInt(min);
			int largerstNum = Integer.parseInt(max);
			
			String letter = current.substring(spaceLoc+1,colonLoc);
			String password = current.substring(colonLoc+2);
			
			scanPassword1(smallestNum,largerstNum,letter,password); //part 1
//			scanPassword2(smallestNum,largerstNum,letter,password); //part 2
		}
		return validPasswords;
	}
	
	private static int charLoc(String input, String charToFind) {
		int i = 0;
		while(! input.substring(i, i+1).equals(charToFind)) {
			i++;
		}
		return i;
	}
	
	@SuppressWarnings("unused")
	private static void scanPassword1(int min, int max, String letter, String password) { 
		int letterCounter = 0;
		//finds how many times a letter appears in password
		for (int i=0; i<password.length(); i++) { 
			if(password.substring(i,i+1).equals(letter)) {
				letterCounter++;
			}
		}
		//if the password is within correct range, validPasswords++
		if(letterCounter>=min && letterCounter<=max) {
			validPasswords++;
		}
	}
	
	//check if char at min xor char at max equals given letter
	private static void scanPassword2(int min, int max, String letter, String password) { 
		String spot1 = password.charAt(min-1) + "";
		String spot2 = password.charAt(max-1) + "";
		if(spot1.equals(letter) ^ spot2.equals(letter)) {
			validPasswords++;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(findValidPasswords());
	}
}
