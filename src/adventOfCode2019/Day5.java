package adventOfCode2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day5 extends FileReader{

	static File file = new File("AOC2019/2019day5.txt");
	static ArrayList<String> vals = new ArrayList<>();
	
	public static void test() {
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
		
		
	}
}
