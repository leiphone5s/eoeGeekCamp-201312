package com.fengleiit.wow;

import java.util.Arrays;

import com.fengleiit.swf.Person02;

public class Student extends Person02 {
	public String inSchool;
	public String inClass;
	public Student(){
		
	}
	public Student(String name,char sex,double height,int age,
			String type,String inSchool,String inClass){
		super(name, type, age, height, sex);
		this.inSchool=inSchool;
		this.inClass=inClass;	
	}
	public void swap(int[] a,int i,int j){
		int c=a[i];
		a[i]=a[j];
		a[j]=c;
	}
	public void swap(String[] b,int i,int j){
		String c=b[i];
		b[i]=b[j];
		b[j]=c;
	}
	@Override
	public void say(){
		super.say();
		System.out.println("我在"+inSchool+inClass+"学习");
		
	}
	public static void main(String[] args) {
		Student s1=new Student("张小飞",'男',1.8,22,
				"豪放的","eoe极客学院","1205班");
		Student s2=new Student();
		s1.say();
		System.out.println(s1.name);
		s1.feeling("俺找到好工作啦", "哈哈");
		System.out.println("俺给大家表演两个变量相互交换");
		int[] aa={10,100};
		System.out.println(Arrays.toString(aa));
		System.out.println("变！！！");
		s1.swap(aa, 0, 1);
		System.out.println(Arrays.toString(aa));
		String[] b={"aa","bb"};
		System.out.println(Arrays.toString(b));
	    s2.swap(b,0,1);
	    System.out.println(Arrays.toString(b));
	   
	}
}
