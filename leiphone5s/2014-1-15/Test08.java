package com.eoe.oop.se1.day02;

import java.util.HashMap;

import com.ityw.day09_01.entity.User;



public class Test08 {
public static void main(String[] args) {
	HashMap<Integer, User> users=new HashMap<Integer,User>();
	User user=new User(1001,"张飞", "1234", '男',"北京", "下棋");
	users.put(user.id, user);
	user=new User(1002,"de飞", "1234", '男',"北京", "下棋");
	users.put(user.id, user);
	user=new User(1003,"wa飞", "1234", '男',"北京", "下棋");
	users.put(user.id, user);
	user=new User(1004,"li飞", "1234", '男',"北京", "下棋");
	users.put(user.id, user);
	for(int i=1001;i<1005;i++){
		System.out.println(users.get(i));
	}
	System.out.println();
}
}
