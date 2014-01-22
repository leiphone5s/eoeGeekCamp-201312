package se2.day01;

public class Test11 {
	static int result = 0;

	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					result++;
				}
			}
		};
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}
}
