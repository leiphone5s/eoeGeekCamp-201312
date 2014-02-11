package se2.day06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test08 {
	static LinkedList<String> list;
	// static ArrayList<String> names;
	static Collection<String> names;
	static ListIterator<String> iterator;

	public static void main(String[] args) {
		initList();
		while (iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
		System.out.println("************");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	private static void initList() {
		list = new LinkedList<String>();
		iterator = list.listIterator();

		iterator.add("a");
		iterator.add("b");
		iterator.add("c");
		iterator.add("d");
	}
}
