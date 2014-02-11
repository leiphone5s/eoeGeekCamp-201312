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
		System.out.println("List�ӿ�ʵ�������ʾ��");
		System.out.println("1-ArrayList���ϵĲ���");
		System.out.println("2-LinkedList���ϵĲ���");
		System.out.println("ѡ��1~2");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case ARRAYLIST_ACTION:
			names = new ArrayList<String>();
			break;
		case LINKEDLIST_ACTION:
			names = new LinkedList<String>();
			break;
		default:
			System.out.println("ѡ�����,�������г���");
			System.exit(0);
		}
		init();
		System.out.println(names);
		String[] namesArray = names.toArray(new String[names.size()]);
		System.out.println(Arrays.toString(namesArray));
		iterator();
	}

	private static void init() {
		names.add("�ŷ�");
		names.add("����");
		names.add(1, "�����");
		names.set(0, "��С��");

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
