package se2.day01;

public class Test12 {
	static boolean isPrime;
public static void main(String[] args) {
	FindPrime findPrime=new FindPrime();
	findPrime.start();
}
static class FindPrime extends Thread{
	@Override
	public void run() {
		for(int i=2;i<200;i++){
			IsPrime t=new IsPrime(i);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
static class IsPrime extends Thread{
	int n;
	public IsPrime(int n) {
		this.n=n;
	}
	@Override
	public void run() {
		isPrime=true;
		int k=(int) Math.sqrt(n);
		for(int i=2;i<=k&&isPrime;i++){
			isPrime=n%i!=0;
		}
	}
}
}
