package se2.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Test15 {
	static ArrayList<User> users = new ArrayList<User>();

	public static void main(String[] args) {
		initUsers();
		File dir = new File("d:/se2/day03");
		File file = new File(dir, "test01.txt");
		PrintStream out = null;
		try {
			out = new PrintStream(file);
			for (User user : users) {
				out.println(user);
			}
			System.out.println("write success!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private static void initUsers() {
		users.add(new User(1001, "张飞", '男', 35));
		users.add(new User(1002, "王菲", '女', 32));
		users.add(new User(1003, "刘亦菲", '女', 30));
	}

	static class User {
		private int id;
		private String name;
		private char sex;
		private int age;

		public User() {

		}

		public User(int id, String name, char sex, int age) {
			this.id = id;
			this.name = name;
			this.sex = sex;
			this.age = age;
		}

		@Override
		public String toString() {
			return this.id + "," + this.name + "," + this.age;
		}
	}
}
