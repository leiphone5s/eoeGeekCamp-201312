package com.eoe.oop.se1.day01;

public class Test14 {
public static void main(String[] args) {
	try {
		Thread.sleep(5000);
		System.out.println("谁把俺吵醒了？");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("5秒以后");
}
}
