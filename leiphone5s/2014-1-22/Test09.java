package se2.day01;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		final Thread zhangFei = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println("z....zz......zzz.........");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("À≠∞—∞≥≥≥–—¡À£ø");
						break;
					}
				}
			}
		};
		zhangFei.start();
		new Thread() {
			@SuppressWarnings("resource")
			public void run() {
				System.out.println("º¸≈Ã ‰»Î");
				new Scanner(System.in).next();
				zhangFei.interrupt();
			};
		}.start();
	}
}
