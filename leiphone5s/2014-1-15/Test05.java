package com.eoe.oop.se1.day02;

import java.util.ArrayList;
import java.util.Scanner;

public class Test05 {
public static void main(String[] args) {
	ArrayList<Integer> list=new ArrayList<Integer>();
	Scanner scanner=new Scanner(System.in);
	System.out.println("输入删除的整数:");
	int i=scanner.nextInt();
	list.add(100);
	list.add(200);
	list.add(300);
	list.add(400);
	System.out.println(list);
	list.remove((Integer) i);
	System.out.println(list);
} 
}
