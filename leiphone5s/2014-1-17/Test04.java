package com.eoe.se1.day04;

import java.util.ArrayList;
import java.util.Iterator;

public class Test04 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(150);
		list.add(85);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer i = iterator.next();
			System.out.println(i);
		}
	}
}
