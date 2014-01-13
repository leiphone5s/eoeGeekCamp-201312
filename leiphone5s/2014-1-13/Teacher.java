package com.eoe.oop.day03.entity;

public class Teacher extends Person {
	private String inSchool;
	private String inClass;
	public String getInSchool(){
		return inSchool;
	}
	public void setInSchool(String inSchool){
		this.inSchool=inSchool;
	}
	public String getInClass(){
		return inClass;
	}
	public void setInClass(String inClas){
		this.inClass=inClass;
	}
	public void say(){
		super.say();
		System.out.println("俺在eoe学院任课");
	}
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	public Teacher(String name, char sex, int age, double height, String type,
			String inSchool, String inClass) {
		super(name, sex, age, height, type);
		this.inSchool = inSchool;
		this.inClass = inClass;
	}
	@Override
	public void doing() {
		// TODO Auto-generated method stub
		this.say();
		System.out.println(this.name+"正在"+inSchool+"备课\n");
	}
	
}
