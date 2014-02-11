package se2.day06;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Test10 {
	static LinkedList<String> list;
	static ListIterator<String> iterator;

	public static void main(String[] args) {
		initList();
		System.out.println("1-��ǰ����Ȼ��ɾ����һ��Ԫ��");
		System.out.println("2-��������ɾ��ǰһ��Ԫ��");
		System.out.println("3-�������ײ���,����β���һ��Ԫ��");
		System.out.println("3-��ǰԪ��ǰ������Ԫ��");
		System.out.println("4-��ǰԪ��ǰ������Ԫ��");
		System.out.println("5-�޸���һ��Ԫ��Ϊ��Ԫ��");
		System.out.println("6-��ָ���±����Ԫ��");
		System.out.println("ѡ��1~6");
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
			System.out.println("���ϵĵ�����Ԫ��:" + list.get(2));
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
