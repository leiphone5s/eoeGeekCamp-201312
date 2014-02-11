package se2.day06;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Test10 {
	static LinkedList<String> list;
	static ListIterator<String> iterator;

	public static void main(String[] args) {
		initList();
		System.out.println("1-向前遍历然后删除后一个元素");
		System.out.println("2-向后遍历并删除前一个元素");
		System.out.println("3-在链表首插入,链表尾添加一个元素");
		System.out.println("3-当前元素前插入新元素");
		System.out.println("4-当前元素前插入新元素");
		System.out.println("5-修改上一个元素为新元素");
		System.out.println("6-按指定下标访问元素");
		System.out.println("选择1~6");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case 1:
			if (iterator.hasPrevious()) {
				iterator.previous();
				iterator.remove();
				System.out.println(list);
			}
			break;
		case 2:
			while (iterator.hasPrevious()) {
				iterator.hasPrevious();
			}
			if (iterator.hasNext()) {
				iterator.next();
				iterator.remove();
				System.out.println(list);
			}
			break;
		case 3:
			list.addFirst("aa");
			list.addLast("dd");
			System.out.println(list);
			break;
		case 4:
			while (iterator.hasPrevious()) {
				iterator.previous();
			}
			iterator.next();
			iterator.next();
			iterator.add("bc");
			System.out.println(list);
			break;
		case 5:
			while (iterator.hasPrevious()) {
				iterator.previous();
			}
			iterator.next();
			iterator.next();
			iterator.set("bb");
			System.out.println(list);
			break;
		case 6:
			System.out.println("集合的低三个元素:" + list.get(2));
			break;
		}
	}

	private static void initList() {
		list = new LinkedList<String>();
		iterator = list.listIterator();
		iterator.add("a");
		iterator.add("b");
		iterator.add("c");
		iterator.add("d");
		System.out.println(list);
	}
}
