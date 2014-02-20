package com.eoe.se2.day12.entity1;

public class Button extends View {
	private static String onclick;

	public static String getOnclick() {
		return onclick;
	}

	public static void setOnclick(String onclick) {
		Button.onclick = onclick;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
