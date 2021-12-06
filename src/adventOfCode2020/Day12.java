package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day12 extends FileReader {

	static File file = new File("AOC/day12.txt");
	static ArrayList<String> values = new ArrayList<>();
	private static int dir = 0; //direction: 0-E, 1-S, 2-W, 3-N
	private static int xDist = 0;
	private static int yDist = 0;
	private static int wayX = 10; //waypoint x coordinate
	private static int wayY = 1; //waypoint y coordinate
	
	public static int findDist() {
		for (int i=0; i<values.size(); i++) {
			char move = values.get(i).charAt(0);
			int num = Integer.parseInt(values.get(i).substring(1));
			
			switch(move) {
				case 'F':
					if(dir==0) xDist+=num;
					else if(dir==1) yDist-=num;
					else if(dir==2) xDist-=num;
					else if(dir==3) yDist+=num;
					break;
				case 'R':
					if(num==90) dir = (dir + 1) % 4;
					else if(num==180) dir = (dir + 2) % 4;
					else if(num==270) dir = (dir + 3) % 4;
					break;
				case 'L':
					if(num==90) dir = (dir + 3) % 4;
					else if(num==180) dir = (dir + 2) % 4;
					else if(num==270) dir = (dir + 1) % 4;
					break;
				case 'E':
					xDist+=num;
					break;
				case 'S':
					yDist-=num;
					break;
				case 'W':
					xDist-=num;
					break;
				case 'N':
					yDist+=num;
					break;
				default:
					System.out.println("ERROR");
					break;
			}
		}
		return Math.abs(xDist) + Math.abs(yDist);
	}
	
	public static int findDist2() {
		for (int i=0; i<values.size(); i++) {
			char move = values.get(i).charAt(0);
			int num = Integer.parseInt(values.get(i).substring(1));
			int xTemp = wayX;
			int yTemp = wayY;
			
			switch(move) {
				case 'F':
					xDist += num*wayX;
					yDist += num*wayY;
					break;
				case 'R':
					if(num==90) {
						wayX = yTemp;
						wayY = -xTemp;
					}
					else if(num==180) {
						wayX = -xTemp;
						wayY = -yTemp;
					}
					else if(num==270) {
						wayX = -yTemp;
						wayY = xTemp;
					}
					break;
				case 'L':
					if(num==90) {
						wayX = -yTemp;
						wayY = xTemp;
					}
					else if(num==180) {
						wayX = -xTemp;
						wayY = -yTemp;
					}
					else if(num==270) {
						wayX = yTemp;
						wayY = -xTemp;
					}
					break;
				case 'E':
					wayX += num;
					break;
				case 'S':
					wayY -= num;
					break;
				case 'W':
					wayX -= num;
					break;
				case 'N':
					wayY += num;
					break;
				default:
					System.out.println("ERROR");
					break;
			}
		}
		return Math.abs(xDist) + Math.abs(yDist);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,values);
//		System.out.println("RESULT: " + findDist()); //part 1
		System.out.println("RESULT: " + findDist2()); //part 2
		
	}
}
