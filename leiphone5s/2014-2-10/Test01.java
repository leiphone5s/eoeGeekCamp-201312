package se2.day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test01 {
	public static void main(String[] args) {
		ExecutorService pools = Executors.newFixedThreadPool(3);
		pools.execute(new MyThread("’≈∑…"));
		pools.execute(new MyThread("Õı∑∆"));
		pools.execute(new MyThread("¡ı“‡∑∆"));
		pools.execute(new Thread() {
			@Override
			public void run() {
				for (int i = 1; i < 10; i++) {
					System.out.println("øß∑»‘⁄Ã¯ŒË..." + i);
				}
			}
		});
		pools.shutdown();
	}

	static class MyThread extends Thread {
		String name;

		public MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				if ("’≈∑…".equals(name)) {
					System.out.println(name + "‘⁄…‰º˝...");
				} else if ("Õı∑∆".equals(name)) {
					System.out.println(name + "‘⁄≥™∏Ë...");
				} else if ("¡ı“‡∑∆".equals(name)) {
					System.out.println(name + "‘⁄—›œ∑...");
				}

			}
		}
	}
}
