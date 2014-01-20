package com.ityw.day09_01.entity;

public class User {
	public int id;
	public String name;
	public String pwd;
	public char sex;
	public String city;
	public String hobby;
	public User(){
		
	}
	public User(int id, String name, String pwd, char sex, String city, String hobby) {
		super();
		this.id=id;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.city = city;
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name="+name+",pwd="+pwd+",sex="+sex+",city="+",hobby="+hobby;
	}
}
