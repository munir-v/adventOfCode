package adventOfCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Template extends FileReader {

	static File file = new File("AOC2018/2018day.txt");
	static ArrayList<String> vals = new ArrayList<>();
	
	public static void part1() {
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(file,vals);
		part1();
		
	}
}