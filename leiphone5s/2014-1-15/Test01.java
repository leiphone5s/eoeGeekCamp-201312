package com.eoe.oop.se1.day02;

import java.util.ArrayList;
import java.util.Scanner;//张飞,吗啡,刘亦菲,刘晓飞

public class Test01 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个人名:");
		String s1=scanner.next();
		ArrayList<String> names = new ArrayList<String>();
		names.add("张飞");
		names.add("王菲");
		names.add("刘亦菲");
		names.add("咖啡");
		if(names.contains(s1)==true){
			System.out.println("是该集合的元素");
		}else{
			System.out.println("不是该集合的元素");
		}
		System.out.println();	
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		System.out.println();
		names.set(2, "王大飞");
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println();
		names.remove(1);
		System.out.println(names);
		names.removeAll(names);
		System.out.println();
		if(names.isEmpty()==true){
			System.out.println("集合元素为空,不用清除");
		}else{
		names.removeAll(names);
		}
	}
	
}
