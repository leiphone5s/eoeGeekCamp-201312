package se2.day01;

public class Test03 {
public static void main(String[] args) {
	new Thread(){
		@Override
		public void run() {
			for(int i=1;i<=10;i++){
				System.out.println("worker thread:"+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		}.start();
		for(int i=1;i<=10;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
