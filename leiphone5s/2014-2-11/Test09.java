package se2.day06;

import java.util.Iterator;
import java.util.Scanner;

public class Test09 {
	static ArrayList_<String> names;
	static final int ITERATOR_METHOD = 1;
	static final int FOREACH_METHOD = 2;

	public static void main(String[] args) {
		initNames();
		System.out.println("1-Iterator");
		System.out.println("2-foreach遍历集合");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case ITERATOR_METHOD:
			Iterator<String> iterator = names.iterator();
			while (iterator.hasNext()) {
				String name = iterator.next();
				System.out.println(name);
			}
			break;
		case FOREACH_METHOD:
			for (String name : names) {
				System.out.println(name);
			}
			break;
		}
	}

	private static void initNames() {
		names = new ArrayList_<String>();
		names.add("张飞");
		names.add("王菲");
		names.add("刘亦菲");
		

	}
}
