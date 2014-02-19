package com.eoe.se2.day12;

import java.lang.reflect.Constructor;

public class Test01 {
	static final String PACKAGE = "com.eoe.fengleiit.view.View";

	public static void main(String[] args) {
		Class clazz;
		try {
			clazz = Class.forName(PACKAGE);
			Constructor[] constructors = clazz.getDeclaredConstructors();
			for (Constructor c : constructors) {
				System.out.println(c);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
