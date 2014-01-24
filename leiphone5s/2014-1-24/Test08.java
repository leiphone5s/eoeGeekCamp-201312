package se2.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test08 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		File dir = new File("d:/se2/day03");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test06.txt");
		try {
			fos = new FileOutputStream(file);
			fos.write(65);
			fos.write(0x7a);
			int zhong = 'жа';
			fos.write(zhong >>> 8);
			fos.write(0xff & zhong);
			System.out.println(Integer.toHexString(zhong));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
