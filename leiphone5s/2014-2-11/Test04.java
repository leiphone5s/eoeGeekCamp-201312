package se2.day06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import se2.day03.Users;
import se2.day03.entity.User;

public class Test04 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		File dir = new File("d:/se2/day03");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test02.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			ArrayList<User> users = new ArrayList<User>();
			users.add(new User(1001, "�ŷ�", "1234"));
			users.add(new User(1002, "����", "12345"));
			users.add(new User(1003, "�����", "123456"));
			Users userList=new Users();
			userList.setUsers(users);
			oos.writeObject(users);
			
			
			System.out.println("�������л���ɣ�����");
			
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
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
