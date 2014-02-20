package com.eoe.se2.day12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.eoe.fengleiit.view.View;

public class Test10 {
	static final String PACKAGE = "com.eoe.fengleiit.view.View";

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName(PACKAGE);
			Constructor<?> c = clazz.getConstructor(String.class, String.class,
					String.class, String.class);
			View v = (View) c.newInstance("@+id/view", "300", "100", "ºÚÉ«");
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				System.out.println(field.getName() + ":" + field.get(v));
			}
			fields[1].setAccessible(true);
			fields[1].set(v, "30");
			System.out
					.println(fields[1].getName() + ":" + fields[1].get(v));
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
