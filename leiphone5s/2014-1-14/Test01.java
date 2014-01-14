package com.eoe.oop.se1.day01;

public class Test01 {
	public static void main(String[] args) {
		Number n1 = new Number(12, 26);
		System.out.println(n1);
		swap(n1);
		System.out.println(n1);
	}

	static void swap(Number num) {
		int temp = num.a;
		num.a = num.b;
		num.b = temp;
	}

	static class Number {
		int a;
		int b;

		public Number(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public Number() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Number [a=" + a + ", b=" + b + "]";
		}

	}
}
