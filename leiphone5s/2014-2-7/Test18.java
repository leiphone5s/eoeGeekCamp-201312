package se2.day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PushbackInputStream;

public class Test18 {
	static final String PATH = "d:/se2/day03";
	static final String FILE_NAME = "test08.txt";

	public static void main(String[] args) {
		byte space = (int) ' ';
		byte[] spaces = { space, space, space, space };
		FileInputStream fis = null;
		PushbackInputStream pis = null;
		PrintStream out = null;
		File dir = new File(PATH);
		if (!dir.exists()) {
			System.out.println(PATH + "不存在");
			return;
		}
		File file = new File(dir, FILE_NAME);
		if (!file.exists()) {
			System.out.println(FILE_NAME + "不存在");
			return;
		}
		try {
			fis = new FileInputStream(file);
			pis = new PushbackInputStream(fis, 4);
			out = new PrintStream(System.out);
			int c;
			while ((c = pis.read()) != -1) {
				if (c == '{') {
					pis.unread('\n');
				}
				if (c == '}') {
					out.println();
				}
				if (c == '\n') {
					pis.unread(spaces);
				}

				out.print((char) c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pis != null) {
				try {
					pis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
