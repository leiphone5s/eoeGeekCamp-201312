package com.fengleiit.work;

import java.util.Scanner;

public class Exercise009 {
	public static void main(String[] args) {
		int n,value;
		AAA: while(true){Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个整数:");
	    n=scanner.nextInt();
		value=f(n);
		System.out.println(value);
		continue AAA;
	}
	}
	public static int f(int n){
		if(n==1||n==2)
			return 1;
		
		return f(n-1)+f(n-2);
	}
}
