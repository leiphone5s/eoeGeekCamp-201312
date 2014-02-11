package se2.day06;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Test01 {
	public static void main(String[] args) {
		final Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("呼噜...");
				try {
					Thread.sleep(1000 * 60 * 60);
				} catch (InterruptedException e) {
					System.out.println("叮铃铃...,又该起床了！");
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
		}, 1000 * 2);
	}
}
