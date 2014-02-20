package com.eoe.se2.day12;

import java.util.HashMap;

import com.eoe.fengleiit.view.View;

public class Activity {
	static HashMap<String, String> bundles;

	static <T extends View> T findViewById(int id) {
		initBundles();
		String key = "0x" + Integer.toHexString(id);
		String value = bundles.get(key);
		try {
			Class<?> clazz = Class.forName(value);
			T view = (T) clazz.newInstance();
			view.setBackground("ºÚÉ«");
			view.setId("view");
			view.setLayout_height("300dp");
			view.setLayout_width("200dp");
			return view;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private static void initBundles() {
		bundles = new HashMap<>();
		bundles.put("0x70051", "com.eoe.fengleiit.view.TextView");
		bundles.put("0x70052", "com.eoe.fengleiit.view.EditText");
		bundles.put("0x70053", "com.eoe.fengleiit.view.Button");

	}
}
