package adventOfCode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 extends FileReader {
	
	static File file = new File("AOC2021/day4test.txt");	
	static ArrayList<String> vals = new ArrayList<>();
	static ArrayList<Integer> bingo = new ArrayList<>();
	static String[] numsDrawn; //total list of #s to be drawn
	static int lastNumCalled; //the last number called

	//reads the first line of the file (numbers drawn) to a string array
	private static void readNumsDrawn() throws FileNotFoundException {
		Scanner in = new Scanner(file);
		String n = in.nextLine();
		numsDrawn = n.split(","); 
		
		in.close();
	}
	
	//reads the rest of the bingo boards to an arraylist, one num at each index
	private static void readBoardNums() {
		vals.remove(0);
		for (int i=0; i<vals.size(); i++) {
			String[] values = vals.get(i).split("[^\\d+]"); //read only numbers
			for (String s : values) {
				if(s.trim().length()>0) {
					bingo.add(Integer.parseInt(s.trim()));
				}
			}
		}
	}
	
	//sets all bingo slot to -1 if they equal the number called
	private static void newRound() {
		for (int i=0; i<bingo.size(); i++) {
			if(bingo.get(i)==lastNumCalled) {
				bingo.set(i,-1);
			}
		}
	}
	
	//checks the bingo array for 5 -1's in a row, indicating a horz win, returns winning board#
	private static int checkHorz() {
		int boardNum = -1;
		int total = 0;
		
		for (int i=0; i<bingo.size(); i+=5) { //each row
			total = 0;
			for (int j=i; j<i+5; j++) { //each num
				total+=bingo.get(j);
			}
			if(total==-5) {
				boardNum=i/25;
				break;
			}
		}
		return boardNum;
	}
	
	//checks the bingo array for 5 -1's in a column, indicating a vert win, returns winning board#
	private static int checkVert() {
		int boardNum = -1;
		int total = 0;
		
		outer:
		for (int i=0; i<bingo.size(); i+=25) { //each board
			for (int j=i; j<i+5; j++) { //each column
				total = 0;
				for (int k=j; k<j+25; k+=5) { //each num
					total+=bingo.get(k);
				}
				if(total==-5) { //5 in a column
					boardNum=i/25;
					break outer;
				}
			}
		}
		return boardNum;
	}
	
	//returns the number of the winning board
	private static int winningBoard() {
		int retval = -1;
		
		for (int i=0; i<numsDrawn.length; i++) {
			lastNumCalled = Integer.parseInt(numsDrawn[i]);
			newRound();
			if(checkHorz()!=-1) {
				retval = checkHorz();
				break;
			}
			else if(checkVert()!=-1) {
				retval = checkVert();
				break;
			}
		}
		return retval;
	}
	
	//returns the score (sum of all unmarked numbers)
	private static int bingoScore() {
		int score = 0;
		int winningBoard = winningBoard();
		System.out.println("winningBoard: " + winningBoard);

		for (int i=winningBoard*25; i<winningBoard*25+25; i++) {
			int curNum = bingo.get(i);
			if(curNum!=-1) {
				score+=curNum;
			}
		}
		return score;
	}
	
	public static int part1() throws FileNotFoundException {
		readNumsDrawn();
		readBoardNums();
		int score = bingoScore();

		System.out.println("score: " + score);
		System.out.println("lastNumCalled: " + lastNumCalled);
		
		return score*lastNumCalled;
	}
	

	//returns the number of the last board to win
	private static int losingBoard() {
		int retval = -1;
		
		for (int i=0; i<numsDrawn.length; i++) {
			lastNumCalled = Integer.parseInt(numsDrawn[i]);
			newRound();
			if(checkHorz()!=-1) {
				retval = checkHorz();
				break;
			}
			else if(checkVert()!=-1) {
				retval = checkVert();
				break;
			}
		}
		return retval;
	}
	
	//returns the score of the last board to win (sum of all unmarked numbers)
	private static int bingoScoreLast() {
		int score = 0;
		int winningBoard = winningBoard();
		System.out.println("winningBoard: " + winningBoard);

		for (int i=winningBoard*25; i<winningBoard*25+25; i++) {
			int curNum = bingo.get(i);
			if(curNum!=-1) {
				score+=curNum;
			}
		}
		return score;
	}
	
	public static int part2() throws FileNotFoundException {
		readNumsDrawn();
		readBoardNums();
		int score = bingoScore();

		System.out.println("score: " + score);
		System.out.println("lastNumCalled: " + lastNumCalled);
		
		return score*lastNumCalled;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
//		System.out.println("answer: " + part1());
		System.out.println("answer: " + part2());
	}
}