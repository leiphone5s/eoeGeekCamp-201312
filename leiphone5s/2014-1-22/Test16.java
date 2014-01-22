package se2.day01;

import java.util.ArrayList;
import java.util.Scanner;

public class Test16 {
static ArrayList<String> tasks=new ArrayList<String>();
public static void main(String[] args) {
	final Thread t1=new Thread("t1"){
		String s="";
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(1000*60*60);
				} catch (InterruptedException e) {
					while(tasks.size()>0){
						for(int i=1;i<=100000;i++){
							s+="a";
						}
						s=tasks.remove(0);
						if("q".equals(s)){
							break;
						}
						System.out.println(s);
					}
				}
				if("q".equals(s)){
					System.out.println("game over!");
					break;
				}
			}
		}
	};
	t1.start();
	final Scanner scanner=new Scanner(System.in);
	Thread t2=new Thread(){
		@Override
		public void run() {
			while(true){
				System.out.println("ÊäÈë×Ö·û´®");
				String text=scanner.next();
				tasks.add(text);
				t1.interrupt();
			}
		}
	};
	t2.setDaemon(true);
	t2.start();
}
}
