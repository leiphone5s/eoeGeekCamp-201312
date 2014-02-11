package se2.day06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import se2.day03.Users;
import se2.day03.entity.User;

public class Test05 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		File dir = new File("d:/se2/day03");
		if (!dir.exists()) {
			System.out.println("文件夹不存在");
			return;
		}
		File file = new File(dir, "test02.txt");
		if (!file.exists()) {
			System.out.println("test02.txt不存在");
			return;
		}
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			Users users = new Users();
			users = (Users) ois.readObject();
			for (User u : users.getUsers()) {
				System.out.println(u);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
