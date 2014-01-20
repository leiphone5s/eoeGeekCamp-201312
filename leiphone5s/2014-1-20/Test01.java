package se1.day04;

import java.util.HashMap;
import java.util.Set;

import com.ityw.day09_01.entity.User;

public class Test01 {
public static void main(String[] args) {
	HashMap<Integer, User> users=new HashMap<>();
	User user=new User(1001, "aa", "1245", 'ÄĞ', "ww", "qq");
	users.put(user.id,user);
	user=new User(1002, "bb", "1245", 'ÄĞ', "ww", "qq");
	users.put(user.id, user);
	user=new User(1003, "cc", "123", 'ÄĞ', "biej", "adf");
	users.put(user.id, user);
	Set<Integer> keys=users.keySet();
	for(Integer key:keys){
		User  u=users.get(key);
		System.out.println(u);
	}
}
}
