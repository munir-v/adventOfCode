package adventOfCode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import adventOfCode2020.FileReader;

public class Template extends FileReader {

	static File file = new File("AOC15/day.txt");
	static ArrayList<String> values = new ArrayList<>();
	
	public static void test() {
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,values);
		
		
	}
}
