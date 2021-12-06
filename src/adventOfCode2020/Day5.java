package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Day5 extends FileReader {
	
	static File file = new File("AOC/day5.txt");
	static ArrayList<String> values = new ArrayList<>();
	static ArrayList<Integer> seatID = new ArrayList<>();
	
	public static int findMaxID() {
		for (int i=0; i<values.size(); i++) {
			int topRow = 128;
			int bottomRow = 0;
			int topSeat= 8;
			int bottomSeat = 0;
			
			String str = values.get(i);
			for (int j=0; j<7; j++) { //row #
				if(str.substring(j,j+1).equals("F")) {
					topRow = (topRow - bottomRow)/2 + bottomRow;
				}
				else {
					bottomRow += (topRow - bottomRow)/2;
				}
			}
			
			for (int j=0; j<3; j++) { //seat #
				if(str.substring(j+7,j+8).equals("L")) {
					topSeat = (topSeat - bottomSeat)/2 + bottomSeat;
				}
				else {
					bottomSeat += (topSeat - bottomSeat)/2;
				}
			}

			seatID.add(bottomRow * 8 + bottomSeat);
		}
		return Collections.max(seatID);
	}
	
	public static int findMissingSeat() {
		int missingSeat = 0;
		
		Collections.sort(seatID);
		for (int i=0; i<seatID.size()-1; i++) {
			int current = seatID.get(i);
			int current1 = seatID.get(i+1);
			if(!(current == current1-1)) {
				missingSeat = current+1;
			}
		}
		
		return missingSeat;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file, values);
		System.out.println(findMaxID()); //part 1
		System.out.println(findMissingSeat()); //part 2
	}
}
