package se2.day03;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) {
		File dir = new File("d:/se2/day03");
		File file = new File(dir, "test01.txt");
		DataInputStream dis = null;
		if (!file.exists()) {
			System.out.println("文件不存在");
			return;
		}
		try {
			dis = new DataInputStream(new FileInputStream(file));
			int data = dis.readInt();
			double data1 = dis.readDouble();
			String name = dis.readUTF();
			char name1 = dis.readChar();
			char name2 = dis.readChar();
			System.out.println("data: " + data + "\tname: " + name + "\tname1: "
					+ name1 + name2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
