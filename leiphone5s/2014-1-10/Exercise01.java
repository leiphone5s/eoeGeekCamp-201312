package com.fengleiit.wow;

import java.util.Arrays;

import com.fengleiit.swf.Student01;

public class Exercise01 {
	public static void main(String[] args) {
		String data="1001:уе╥и:1234:13010381038:zhangfei@eoemobile.com.cn";
		Student01 s=new Student01();
		String[] strUser=data.split(data);
		System.out.println(Arrays.toString(strUser));
		s.id=Integer.parseInt(strUser[0]);
		s.name=strUser[1];
		s.password=strUser[2];
		s.phone=strUser[3];
		s.email=strUser[4];
		System.out.println(s);
	}
}
