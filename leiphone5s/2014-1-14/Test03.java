package com.eoe.oop.se1.day01;

public class Test03 {
	public static void main(String[] args) {
		class Number {
			int a;
			int b;

			public Number(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public Number() {

			}

			@Override
			public String toString() {
				return "Number [a=" + a + ", b=" + b + "]";
			}

			void swap(Number num) {
				int temp = num.a;
				num.a = num.b;
				num.b = temp;
			}
		}
		Number n1 = new Number(12, 24);
		System.out.println(n1);
		n1.swap(n1);
		System.out.println(n1);
	}
}
