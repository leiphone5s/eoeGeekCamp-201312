package se2.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Test14 {
	public static void main(String[] args) {
		PrintStream out = new PrintStream(System.out);
		out.print("" + 'ÖÐ' + '\t' + 100);
		out.close();
		File dir = new File("d:/se2/day03");
		try {
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir, "test01.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new PrintStream(file);
			out.println('ÖÐ');
			out.println(100);
			Map<String, Object> person = new HashMap<String, Object>();
			person.put("name", "ÕÅ·É");
			person.put("sex", 'ÄÐ');
			person.put("age", 35);
			out.println(person);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
