package com.eoe.se1.day03;

import com.ityw.day09_01.entity.User;

public class Test06 {
	public static void main(String[] args) {
		ArrayList_<User> users = new ArrayList_<User>();
		users.add(new User(12, "张飞", "1246", '男', "北京", "打球"));
		users.add(new User(15, "王飞", "1246", '女', "北京", "打球"));
		users.add(new User(18, "李飞", "1246", '男', "北京", "打球"));
		users.add(new User(17, "赵飞", "1246", '女', "北京", "打球"));
		users.add(new User(16, "钱飞", "1246", '男', "北京", "打球"));
		for(int i=0;i<users.size();i++){
			System.out.println(users.get(i));
		}
	}
	
}
