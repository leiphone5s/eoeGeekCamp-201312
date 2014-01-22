package se2.day01;

import java.util.Scanner;

public class Test06 {
	public enum Season_1 {
		SPRING, SUMMER, AUTUN, WINTER;
	}

	public static void main(String[] args) {
		Season_1 season;
		AAA: while (true) {
			System.out.println("请输入一个数字:");
			System.out.println("1-春天");
			System.out.println("2-夏天");
			System.out.println("3-秋天");
			System.out.println("4-冬天");
			int index = new Scanner(System.in).nextInt();
			season = Season_1.values()[index - 1];
			switch (season) {
			case SPRING:
				System.out.println("春天");
				continue AAA;
			case SUMMER:
				System.out.println("夏天");
				continue AAA;
			case AUTUN:
				System.out.println("秋天");
				continue AAA;
			case WINTER:
				System.out.println("冬天");
				continue AAA;
			}
		}
	}
}