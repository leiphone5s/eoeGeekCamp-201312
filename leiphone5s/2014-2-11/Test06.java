package se2.day06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Test06 {
	static final int ARRAYLIST_ACTION = 1;
	static final int LINKEDLIST_ACTION = 2;
	static final int HASHSET_ACTION = 3;

	public static void main(String[] args) {
		System.out.println("1-ArrayList集合的常用操作");
		System.out.println("2-LinkedList集合的常用操作");
		System.out.println("3-HashSet集合的常用操作");
		System.out.println("选择1~3");
		Collection<String> names;
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case ARRAYLIST_ACTION:
			names = new ArrayList<String>();
			names.add("张飞");
			names.add("王菲");
			names.add("刘亦菲");
			for (String name : names) {
				System.out.println(name);
			}
			break;
		case LINKEDLIST_ACTION:
			names = new LinkedList<String>();
			names.add("张飞");
			names.add("王菲");
			names.add("刘亦菲");
			for (String name : names) {
				System.out.println(name);
			}
			break;
		case HASHSET_ACTION:
			names = new HashSet<String>();
			names.add("张飞");
			names.add("王菲");
			names.add("刘亦菲");
			for (String name : names) {
				System.out.println(name);
			}
			break;
		}

	}
}
