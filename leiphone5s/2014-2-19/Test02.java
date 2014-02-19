package com.eoe.se2.day12;

public class Test02 {
public static void main(String[] args) {
	print(0,"hello");
	print(0,"hello","world");
	print(0,"hello","world","android");
}
static void print(int count,String...args){
	for (String arg : args) {
		System.out.print(arg+" ");
	}
	System.out.println();
}
}
