package se2.day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test06 {
	public static void main(String[] args) {
		String fileName = "D:\\se2\\day01\\java.txt";
		FileInputStream fis = null;
		byte[] data = new byte[1024];
		StringBuilder sb = new StringBuilder();
		try {
			fis = new FileInputStream(fileName);
			for (int len; (len = fis.read(data)) != -1;) {
				sb.append(new String(data));
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
