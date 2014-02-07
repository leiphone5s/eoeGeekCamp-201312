package se2.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Test16 {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		out.print('жа');
		out.println("\t" + 100);
		out.flush();
		out.close();
		File dir = new File("d:/se2/day03");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test08.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new PrintWriter(file);
			out.print('жа');
			out.println("\t" + 100);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (out != null) {
			out.close();
		}
	}
}
