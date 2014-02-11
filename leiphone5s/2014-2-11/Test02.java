package se2.day06;

public class Test02 {
	public static void main(String[] args) {
		MyThread t = new MyThread("tœﬂ≥Ã");
		t.getText();
		t.start();
		String text = t.getText();
		System.out.println(text);
	}

	static class MyThread extends Thread {
		public MyThread(String name) {
			this.setName(name);
		}

		public String text;

		public String getText() {
			System.out.println(this.getName() + "runnable:" + isAlive());
			if (!isAlive()) {
				return null;
			}
			if (text == null) {
				synchronized (this) {
					System.out.println("text=n=null");
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return text;
		}

		@Override
		public void run() {
			text = "hello";
			synchronized (this) {
				notify();
			}
		}

	}
}
