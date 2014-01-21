package se2.day01;

public class Test01 {
public static void main(String[] args) {
	MyThread t=new MyThread();
	t.start();
	for(int i=0;i<=50;i++){
		System.out.println("main thread:"+i);
	}
}
static class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=50;i++){
			System.out.println("MyThread:"+i);
		}
	}
}
}
