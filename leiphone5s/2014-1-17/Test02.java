package com.eoe.se1.day04;

import java.util.ArrayList;

import com.ityw.day09_01.entity.User;

public class Test02 {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("a");
		names.add("bb");
		names.add("ccc");
		printList(names);

		ArrayList<User> users = new ArrayList<User>();
		users.add(new User(12, "aa", "123", 'n', "北京", "篮球"));
		users.add(new User(22, "bbb", "123", 'n', "北京", "篮球"));
		users.add(new User(24, "cccc", "456", 'v', "重庆", "象棋"));
		printList(users);
	}

	public static void printList(ArrayList<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
