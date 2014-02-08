package se2.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Test01 {
	public static void main(String[] args) {
		PrintStream output = new PrintStream(System.out);
		output.println("Hello world!");
		File dir = new File("d:/se2/day03");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test01.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			output = new PrintStream(file);
			output.print("You are excellent!");
			output.close();
			output=new PrintStream(System.out);
			output.println("******");
			System.out.println("88888");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}
	}
}
