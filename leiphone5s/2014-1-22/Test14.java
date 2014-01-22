package se2.day01;

public class Test14 {
	static Integer money = 1000;

	public static void main(String[] args) {
		User user1 = new User("张飞");
		User user2 = new User("王菲");
		User user3 = new User("刘亦菲");
		user1.start();
		user2.start();
		user3.start();
	}

	static class User extends Thread {
		public User(String name) {
			this.setName(name);
		}

		@Override
		public void run() {
			synchronized (money) {
				if (money >= 400) {
					System.out.println(this.getName() + "取出400元");
					money -= 400;
					System.out.println("剩余" + money + "元");
				} else {
					System.out.println("存款不足400元");
				}
			}
		}
	}
}
