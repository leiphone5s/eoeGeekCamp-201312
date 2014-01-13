package com.eoe.oop.day03.entity;

public class Student extends Person {
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
	System.out.println("俺在eoe学院学习");
}
public Student() {
	// TODO Auto-generated constructor stub
}
public Student(String name, char sex, int age, double height, String type,
		String inSchool, String inClass) {
	super(name, sex, age, height, type);
	this.inSchool = inSchool;
	this.inClass = inClass;
}
@Override
public void doing() {
	this.say();
	System.out.println(this.name+"正在"+inSchool+"做作业\n");// TODO Auto-generated method stub
	
}



}
