package com.eoe.se2.day12;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.eoe.fengleiit.view.View;

public class Test05 {
	static final String PACKAGE = "com.eoe.fengleiit.view.View";

	public static void main(String[] args) {
		Class clazz;
		try {
			clazz = Class.forName(PACKAGE);
			Constructor c = clazz.getConstructor();
			View v = (View) c.newInstance();
			v.setBackground("ºÚÉ«");
			v.setId("@+id/view");
			v.setLayout_height("200dp");
			v.setLayout_width("300dp");
			System.out.println(v);
			c = clazz.getDeclaredConstructor(String.class);
			c.setAccessible(true);
			v = (View) c.newInstance("°×É«");
			System.out.println(v);
			c = clazz.getConstructor(String.class, String.class, String.class,
					String.class);
			v = (View) c.newInstance("@+id/view  ", "300dp  ", "200dp  ", "À¶É«    ");
			System.out.println(v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
