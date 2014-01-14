package com.eoe.oop.se1.day01;

public class Test11 {
 public static void main(String[] args) {
	method1();
	System.out.println("main");
}
 private static void method1(){
	 try{
		 method2();
	 }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.toString()); 
	 }
	 System.out.println("method1");
 }
 private static void method2(){
	int[] a=new int[2];
	System.out.println(a[2]);
	System.out.println("俺不会被执行到");
 }
}
