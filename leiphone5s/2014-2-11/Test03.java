package se2.day06;

import java.io.File;
import java.io.FileFilter;

public class Test03 {
	static final String dir = "d:/se2/day03";

	public static void main(String[] args) {
		File file = new File(dir);
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isFile() && pathname.getName().endsWith("txt");
			}
		});
		for (File f : files) {
			System.out.println(f.getName());
		}
	}
}
