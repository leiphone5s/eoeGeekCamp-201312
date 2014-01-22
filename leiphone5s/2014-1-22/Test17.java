package se2.day01;

import java.util.Timer;
import java.util.TimerTask;

public class Test17 {
public static void main(String[] args) {
	final Thread t=new Thread("’≈∑…"){
		@Override
		public void run() {
			while(true){
				System.out.println(this.getName()+"z.....z......zz.......");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("À≠∞—∞≥≥≥–—¡À£ø");
					break;
				}
			}
		}
	};
	t.start();
	final Timer timer=new Timer();
	timer.schedule(new TimerTask() {
		
		@Override
		public void run() {
		t.interrupt();
		timer.cancel();
			
		}
	}, 5*1000);
}
}
