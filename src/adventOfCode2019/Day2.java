package adventOfCode2019;

import java.util.ArrayList;
import java.util.Arrays;

public class Day2 {

	private static final ArrayList<Integer> ORIGINAL = new ArrayList<Integer>(Arrays.asList(1,0,0,3,1,1,2,3,
			1,3,4,3,1,5,0,3,2,13,1,19,1,19,6,23,1,23,6,27,1,13,27,31,2,13,31,35,1,5,35,
			39,2,39,13,43,1,10,43,47,2,13,47,51,1,6,51,55,2,55,13,59,1,59,10,63,1,63,10,
			67,2,10,67,71,1,6,71,75,1,10,75,79,1,79,9,83,2,83,6,87,2,87,9,91,1,5,91,95,
			1,6,95,99,1,99,9,103,2,10,103,107,1,107,6,111,2,9,111,115,1,5,115,119,1,10,
			119,123,1,2,123,127,1,127,6,0,99,2,14,0,0));
	private static ArrayList<Integer> values = new ArrayList<>(ORIGINAL);
	
	public void testNew(int pos1, int pos2) {
		values.set(1, pos1);
		values.set(2, pos2);
		
		for (int i=0; i<values.size(); i+=4) { //increase by 4 every time until the program ends
			/* if value is 1, add values at positions of values.get(i+1) and .get(i+2)
			then replace with the value of position values.get(i+3)*/
			if(values.get(i)==1) { 
				int valOfFirst = values.get(i+1);
				int valOfSecond = values.get(i+2);
				int posOfResult = values.get(valOfFirst)+values.get(valOfSecond);
				if(values.get(i+3)<values.size()) {	
					values.set(values.get(i+3),posOfResult); //set value at pos3 to pos1 + pos2 
				}
				else break;
			}
			/* if value is 1, multiply values a positions of values.get(i+1) and .get(i+2)
			then replace with the value of position values.get(i+3)*/
			else if(values.get(i)==2) {
				int valOfFirst = values.get(i+1);
				int valOfSecond = values.get(i+2);
				int posOfResult = values.get(valOfFirst)*values.get(valOfSecond);
				if(values.get(i+3)<values.size()) {	
					values.set(values.get(i+3),posOfResult); //set value at pos3 to pos1 * pos2
				}
				else break;
			}
			else if(values.get(i)==99) break; //if value is 99, end the program
		}
	}

	//determine what pair of inputs produces the output 19690720
	public int test2() {
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				values = new ArrayList<>(ORIGINAL);
				testNew(i,j);
				if(values.get(0)==19690720) { 
					return 100*i+j; //we want 100 * (value at 1) + (value at 2)
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Day2 bob = new Day2();
		bob.testNew(12,2);
		System.out.println(values.get(0)); //part 1 answer
		System.out.println(bob.test2()); //part 2 answer
	}
}
