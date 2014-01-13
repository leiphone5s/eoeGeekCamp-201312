package com.eoe.oop.day03.entity;

import java.util.Arrays;

@SuppressWarnings("unused")
public abstract class Person {
	protected String name;
	protected char sex;
	protected int age;
	protected double height;
	protected String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		if (sex == '男' || sex == '女') {
			this.sex = sex;
		} else {
			this.sex = '男';
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0 || age < 200) {
			this.age = age;
		} else {
			System.out.println("年龄不合理！");
		}
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height > 0 || height < 3) {
			this.height = height;
		} else {
			System.out.println("身高不正常！");
		}
	}

	public String type() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void say() {
		System.out.println("姓名:" + name + "性别:" + sex + "年龄:" + age
				+ "身高:" + height + "性格:" + type);
	}
public Person() {
	// TODO Auto-generated constructor stub
}

public Person(String name, char sex, int age, double height, String type) {
	super();
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.height = height;
	this.type = type;
}
public abstract void doing();
public static void main(String[] args) {
	
}
}
