package se2.day01;

import java.util.Arrays;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		String[] names = { "张飞", "王菲", "刘亦菲", "咖啡" };
		System.out.println(Arrays.toString(names));
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入删除的位置(1~4):");
		int index = scanner.nextInt();
		if (index > 0 && index < 5) {
			for (int i = index; i < names.length; i++) {
				names[i - 1] = names[i];
				names = Arrays.copyOf(names, names.length - 1);//对数组进行减容
				System.out.println(Arrays.toString(names));
			}
		} else {
			System.out.println("输入的数字不在范围之内");
		}
	}
}
