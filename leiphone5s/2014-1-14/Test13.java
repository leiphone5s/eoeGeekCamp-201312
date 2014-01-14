package com.eoe.oop.se1.day01;

import java.util.Scanner;

public class Test13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("a [+,-,*,/] b=");
		int a = scanner.nextInt();
		char c = scanner.next().charAt(0);
		int b = scanner.nextInt();
		try {
			compute4(a, c, b);
		} catch (OutOfIntMaxValueException e) {
			e.printStackTrace();
		} catch (DivideByZero e) {
			e.printStackTrace();
		}

	}

	private static void compute4(int a, char c, int b)
			throws OutOfIntMaxValueException,DivideByZero {
		switch (c) {
		case '+':
			System.out.println(a + b);
			break;
		case '-':
			System.out.println(a - b);
			break;
		case '*':
			System.out.println(a * b);

			// long c1=(long)a*(long)b;
			if (1l * a * b > Integer.MAX_VALUE) {
				throw new OutOfIntMaxValueException("超出int类型最大值");
			}
			break;
		case '/':
			if (b == 0) {
				throw new DivideByZero("除零错误");
			}
			System.out.println(a / b);
			break;
		default:
			System.out.println("输入的不是四则运算符号");
		}
	}

	static class OutOfIntMaxValueException extends Exception {
		public OutOfIntMaxValueException(String message) {
			super(message);
		}
	}
	static class DivideByZero extends Exception{
		public DivideByZero(String message){
			super(message);
		}
	}
}