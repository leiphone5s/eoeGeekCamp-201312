package se2.day01;

import java.util.Timer;
import java.util.TimerTask;

public class Test20 {
	public static void main(String[] args) {
		final Thread t = new Thread("’≈∑…") {
			@Override
			public void run() {
				while (true) {
					System.out.println(this.getName() + ":"
							+ "zzz....zzz...zz...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("À≠∞—∞≥≥≥–—¡À?");
						break;
					}
				}
			}
		};
		t.start();
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				t.interrupt();
				timer.cancel();
			}
		}, 5 * 1000);
	}
}
