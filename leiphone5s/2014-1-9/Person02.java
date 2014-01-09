package com.fengleiit.swf;

public class Person02 {
	public String name;
	public char sex;
	public int age;
	public double height;
	public String type;
	public void say(){
		System.out.println("我叫"+name+"我是一位"+"我今年"+age+"岁，"+"我身高"+height+"米"+"是一位性格"+type+"的"+sex+"士");
	}
	public void feeling(String cause,String content){
		System.out.println(cause);
		System.out.println(content);
	}
	public Person02(){
		name="咖啡";
		sex='男';
		age=22;
		height=1.8;
		type="活泼的";
	}
	public Person02(String name){
		this();
		this.name=name;
	}
	public Person02(String name,String type){
		this(name);
		this.type=type;
	}
	public Person02(String name,String type,int age){
		this(name,type);
		this.age=age;
	}
	public Person02(String name,String type,int age,double height){
		this(name,type,age);
		this.height=height;
	}
	public Person02(String name,String type,int age,double height,char sex){
		this(name,type,age,height);
		this.sex=sex;
	}
	@Override
	public String toString() {
		
		return "姓名:"+this.name+" 年龄:"+this.age;
	}
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		Person02 other=null;
		if(obj instanceof Person02){
			other=(Person02) obj;
		}else{
			return false;
		}
		if(obj==this){
			return true;
		}
		return this.name.equals(other.name)&&this.sex==other.sex&&
				this.age==other.age&&this.height==other.height;
	}
	public static void main(String[] args) {
	Person02 p3=new Person02();
		p3.name="王菲";
		p3.type="狂放的";
		p3.age=18;
		p3.height=11.6;
		p3.say();
		p3.feeling("捡钱了", "好的很！");
		System.out.println(p3);
	}
}
