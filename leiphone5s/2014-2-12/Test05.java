package se2.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import se2.day03.entity.User;

public class Test05 {
public static void main(String[] args) {
	User[] users;
	ObjectInputStream ois=null;
	try {
		ois=new ObjectInputStream(new FileInputStream("d://se2/day04/user.dat"));
		users=(User[]) ois.readObject();
		for (User user : users) {
			System.out.println(user);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
