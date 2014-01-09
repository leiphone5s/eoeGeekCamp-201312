package com.fengleiit.wow;

import com.fengleiit.swf.Person02;

public class Text1 {
	
public static void main(String[] args) {
	Person02 p1=new Person02();
	p1.name="张小飞";
	p1.age=22;
	p1.height=1.8;
	p1.sex='男';
	Person02 p2=new Person02();
	p2.name="张小飞";
	p2.age=22;
	p2.height=1.8;
	p2.sex='男';
	if(p1.equals(p2)){
		System.out.println("是一个人");
	}else{
		System.out.println("不是一个人");
	}
	
}
}
