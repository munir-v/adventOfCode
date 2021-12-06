package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day22 extends FileReader {

	static File file1 = new File("2020_Day22/day22_1.txt");
	static File file2 = new File("2020_Day22/day22_2.txt");
	static ArrayList<Integer> plr1 = new ArrayList<>();
	static ArrayList<Integer> plr2 = new ArrayList<>();
	
	public static int findWinner() {
		int retval = 0;
		
		while(plr1.size() > 0 && plr2.size() > 0) {
			nextTurn();
		}
		
		ArrayList<Integer> winner = plr1;
		if(plr2.size() > plr1.size()) winner = plr2;
		
		for (int i=winner.size()-1; i>=0; i--) {
			retval += winner.get(i) * (winner.size()-i);
		}

		return retval;
	}
	
	private static void nextTurn() {
		int card1 = plr1.get(0);
		int card2 = plr2.get(0);
		
		if(card1 > card2) {
			plr1.remove(0);
			plr2.remove(0);
			
			plr1.add(card1);
			plr1.add(card2);
		}
		else {
			plr1.remove(0);
			plr2.remove(0);
			
			plr2.add(card2);
			plr2.add(card1);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFileInt(file1,plr1);
		readFileInt(file2,plr2);
		
		System.out.println(findWinner()); //part 1
	}
}
