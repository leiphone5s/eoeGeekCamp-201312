package se2.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Test07 {
	static List<String> names1;
	static final int ARRAYLIST_ACTION = 1;
	static final int LINKEDLIST_ACTION = 2;
	static List<String> names = null;

	public static void main(String[] args) {
		System.out.println("List接口实现类操作示例");
		System.out.println("1-ArrayList集合的操作");
		System.out.println("2-LinkedList集合的操作");
		System.out.println("选择1~2");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case ARRAYLIST_ACTION:
			names = new ArrayList<String>();
			break;
		case LINKEDLIST_ACTION:
			names = new LinkedList<String>();
			break;
		default:
			System.out.println("选择错误,重新运行程序");
			System.exit(0);
		}
		init();
		System.out.println(names);
		String[] namesArray = names.toArray(new String[names.size()]);
		System.out.println(Arrays.toString(namesArray));
		iterator();
	}

	private static void init() {
		names.add("张飞");
		names.add("王菲");
		names.add(1, "刘亦菲");
		names.set(0, "张小飞");

	}

	private static void iterator() {
		ListIterator<String> iterator = names.listIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("***************");
		while (iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
	}

}
