package adventOfCode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Template extends FileReader {

	static File file = new File("AOC/day.txt");
	static ArrayList<String> values = new ArrayList<>();
	
	public static void test() {
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,values);
		
		
	}
}