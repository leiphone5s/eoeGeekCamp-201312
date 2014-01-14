package com.eoe.oop.se1.day01;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		System.out.println("1-内存溢出异常");
		System.out.println("2-数组下标越界异常");
		System.out.println("3-空指针异常");
		System.out.println("4-转换异常");
		System.out.println("5-除零错误异常");
		System.out.println("6-强制类型转换异常");
		Scanner scanner = new Scanner(System.in);
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			double[] a = new double[1000000000];
			break;
		case 2:
			int[] b = new int[3];
			System.out.println(b[4]);
			break;
		case 3:
			int[] c = null;
			System.out.println(c[0]);
			break;
		case 4:
			String name = "aa";
			int d = Integer.parseInt(name);
			break;
		case 5:
			System.out.println(5 / 0);
			break;
		case 6:
			String s = "ss";
			Object o = s;
			Integer i = (Integer) o;
			break;
		default:
			System.out.println("输入的数字不在范围之内");
		}
	}
}
