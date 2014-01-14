package com.eoe.oop.se1.day01;

import com.eoe.oop.day03.entity.Person;
import com.eoe.oop.day03.entity.Student;
import com.eoe.oop.day03.entity.Teacher;


public class Test04 {
public static void main(String[] args) {
	Person[] people=new Person[4];//调用抽象类
	people[0]=new Student("吗啡",'男',22,1.8,"豪爽的","eoe学院","1205班");
	people[1]=new Teacher("咖啡",'女',23,1.8,"很牛的","eoe学院","1205班");
	people[2]=new Student("王菲",'女',24,1.7,"漂亮的","eoe学院","1205班");
	people[3]=new Person("张飞",'男',24,1.8,"狂野的") {
		String unit="中央戏剧学院";
		String work="演员";
		@Override
		public void doing() {
			// TODO Auto-generated method stub
			System.out.println("正在演戏...");
		}
		public void say(){
			super.say();
			System.out.println("俺在"+unit+"当"+work);
		}
	};
	for(Person p:people){
		p.say();
		p.doing();
		System.out.println("***********************");
	}
}
}
