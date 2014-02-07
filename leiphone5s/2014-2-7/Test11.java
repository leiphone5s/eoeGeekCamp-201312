package se2.day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import se2.day03.entity.User;

public class Test11 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			ois = new ObjectInputStream(new FileInputStream(
					"d:/se2/day03/test08.txt"));
			User user3;
			while ((user3 = (User) ois.readObject()) != null) {
				users.add(user3);
				System.out.println(user3);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.toString());
			for (User u : users) {
				System.out.println(u);
			}
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
