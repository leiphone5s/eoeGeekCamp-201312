package com.eoe.oop.se1.day01;

public class Test16 {
public static void main(String[] args) {
	System.out.println("a="+compute());
}
static int compute(){
	int a=5;
	try {
		int b=a/2;
	} catch (Exception e) {
		return a+=5;
	}finally{
		System.out.println("hello world!");//return a+=5;
	}
	return a=5;
}
}
