package adventOfCode2019;

import java.util.ArrayList;

public class Day4 {

	static ArrayList<Integer> values = new ArrayList<>();
	static ArrayList<Integer> numberOfPasswords1 = new ArrayList<>();
	static ArrayList<Integer> numberOfPasswords2 = new ArrayList<>();
	
	public void findIncreasingNums() {
		boolean good = true;
		for (int i=367479; i<893698; i++) { //convert all values to chars then to individual ints
			char[] digitsAsChars = String.valueOf(i).toCharArray();
			int[] digits = new int[6];
			for(int j=0; j<6; j++){
			   digits[j] = digitsAsChars[j];
			}
			
			for (int j=0; j<5; j++) { //check if each digit is increasing
				if(digits[j] < digits[j+1] || digits[j] == digits[j+1]) { 
					good=true;
				}
				else {
					good=false;
					break;
				}
			}
			if(good) { //if increasing, add to values
				values.add(i);
			}
		}
	}
	
	public void findAdjacentNums() {
		boolean good = true;
		for (int i=0; i<values.size(); i++) {  //convert all values to chars then to individual ints
			char[] digitsAsChars = String.valueOf(values.get(i)).toCharArray();
			int[] digits = new int[6];
			for(int j=0; j<6; j++){
			   digits[j] = digitsAsChars[j];
			}
			
			for (int j=0; j<5; j++) { //check for adjacent digits
				if(digits[j] == digits[j+1]) { 
					good=true;
					break;
				}
				else {
					good=false;
				}
			}
			if(good) { //if number has any adjacent digits, add to numberOfPasswords
				numberOfPasswords1.add(values.get(i));
			}
		}
	}
	
	public void findNonGroupedNums() {
		boolean good = true;
		for (int i=0; i<numberOfPasswords1.size(); i++) {  //convert all values to chars then to individual ints
			char[] digitsAsChars = String.valueOf(numberOfPasswords1.get(i)).toCharArray();
			int[] digits = new int[digitsAsChars.length];
			for(int j=0; j<6; j++){
			   digits[j] = digitsAsChars[j];
			}
			
			for (int j=0; j<5; j++) { //check for 2 adjacent digits only
				if(digits[j] == digits[j+1]) {
					if(j==0) {
						if(digits[j] != digits[j+2]) {
							good=true;
							break;
						}
					}
					else if(j==4) {
						if(digits[j] != digits[j-1]) {
							good=true;
							break;
						}
					}
					else if(j>0 && j<4) {
						if(digits[j] != digits[j-1] && digits[j] != digits[j+2]) {
							good=true;
							break;
						}
					}
					else good=false;
				}
				else good=false;
			}
			if(good) { //if number has only 2 adjacent digits, add to numberOfPasswords
				numberOfPasswords2.add(numberOfPasswords1.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		Day4 obj = new Day4();
		obj.findIncreasingNums();
		obj.findAdjacentNums();
		System.out.println(numberOfPasswords1);
		System.out.println("numberOfPasswords: " + numberOfPasswords1.size()); //part 1 answer
		
		obj.findNonGroupedNums();
		System.out.println(numberOfPasswords2);
		System.out.println("new numberOfPasswords: " + numberOfPasswords2.size()); //part 2 answer
	}
}
