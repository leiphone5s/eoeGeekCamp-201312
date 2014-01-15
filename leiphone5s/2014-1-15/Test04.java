package com.eoe.oop.se1.day02;

import java.util.ArrayList;
import java.util.HashMap;

public class Test04 {
static ArrayList<Integer_> list,list2;
public static void main(String[] args) {
	initList();
	list2=new ArrayList<Integer_>();
	list2.add(list.get(0));
	list2.add(list.get(1));
	System.out.println(list2.get(0)==list.get(0));
	Integer_ i=list.get(0);
	i.value=100;
	System.out.println(list2.get(0)==list.get(0));
}
private static void initList() {
	list=new ArrayList<Integer_>();
	list.add(new Integer_(100));
	list.add(new Integer_(300));	
}
static class Integer_ extends Object{
	int value;
	public Integer_() {
	}
	public Integer_(int value) {
		this.value = value;
	}
	
}
}
