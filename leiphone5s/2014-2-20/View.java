package com.eoe.se2.day12.entity1;

import java.lang.reflect.Field;
import java.util.Arrays;

public class View {
	private int id;
	private String layout_height;
	private String layout_width;
	private String background;

	public View(int id, String layout_height, String layout_width,
			String background) {
		this.id = id;
		this.layout_height = layout_height;
		this.layout_width = layout_width;
		this.background = background;
	}

	public View() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLayout_height() {
		return layout_height;
	}

	public void setLayout_height(String layout_height) {
		this.layout_height = layout_height;
	}

	public String getLayout_width() {
		return layout_width;
	}

	public void setLayout_width(String layout_width) {
		this.layout_width = layout_width;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append(this.getClass().getSimpleName()).append("\n");
		Field[] fields = {};
		for (Class clazz = this.getClass(); clazz != Object.class; clazz = clazz
				.getSuperclass()) {
			Field[] f = clazz.getDeclaredFields();
			fields = Arrays.copyOf(fields, fields.length + f.length);
			System.arraycopy(f, 0, fields, fields.length - f.length, f.length);
		}
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				if (field == null || field.get(this) == null) {
					continue;
				}
				sb.append(" android:").append(field.getName()).append("=\"")
						.append(field.get(this).toString()).append("\"\n");

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("/>");
		return sb.toString();

	}

	public static void main(String[] args) {
		View view = new View(12, "200dp", "100dp", "black");
		System.out.println(view);
	}
}
