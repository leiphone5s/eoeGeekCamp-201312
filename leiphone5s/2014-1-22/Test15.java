package se2.day01;

import java.util.ArrayList;
import java.util.Scanner;

public class Test15 {
	static ArrayList<String> tasks = new ArrayList<String>();
	public static void main(String[] args) {
		final Thread t1 = new Thread("t1") {
			String s = "";

			@Override
			public void run() {
				while (true) {
					while (tasks.size() > 0) {
						for (int i = 1; i <= 100000; i++) {
							s += "a";
						}
						s = tasks.remove(0);
						if ("q".equals(s)) {
							break;
						}
						System.out.println(this.getName() + ":" + s);
					}
					if ("q".equals(s)) {
						System.out.println("game over!");
						break;
					}
					synchronized (this) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		t1.start();
		final Scanner scanner=new Scanner(System.in);
		Thread t2=new Thread("t2"){
			@Override
			public void run() {
				while(true){
					System.out.println("input text:");
					String text=scanner.next();
					System.out.println(this.getName()+":"+text);
					tasks.add(text);
					synchronized(t1){
						t1.notify();
					}
				}
			}
		};
		t2.setDaemon(true);
		t2.start();
	}
}
