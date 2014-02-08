package se2.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Test03 {
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		pw.println("中国");
		pw.flush();
		File dir = new File("d:/se2/day03");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test02.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			pw = new PrintWriter(file);
			pw.print("大家好啊！");
			System.out.println("数据操作成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
