package com.eoe.se1.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test07 {
public static void main(String[] args) {
	List<Integer> list=new ArrayList<Integer>();
	list.add(100);
	list.add(90);
	list.add(80);
	list.add(95);
	
	ListIterator<Integer> iterator=list.listIterator();
	while(iterator.hasNext()){
		System.out.println(iterator.next()+" ");
	}
	System.out.println();
	while(iterator.hasPrevious()){
		System.out.println(iterator.previous()+" ");
	}
}
}
