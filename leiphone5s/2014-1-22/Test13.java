package se2.day01;

public class Test13 {
	static int money=1000;
public static void main(String[] args) {
	User user1=new User("张飞");
	User user2=new User("王菲");
	User user3=new User("刘亦菲");
	user1.start();
	user2.start();
	user3.start();
}
static class User extends Thread{
	public User(String name) {
		this.setName(name);
	}
	@Override
	public void run() {
		getMoney(this.getName());
	}
}
private static synchronized void getMoney(String name){
	if(money>=400){
		System.out.println(name+"取出400元");
		money-=400;
		System.out.println("剩余"+money+"元");
	}else{
		System.out.println("存款不足400元");
	}
}
}
