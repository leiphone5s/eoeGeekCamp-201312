package se2.day04;

public class Test11 {
	public static void main(String[] args) {
		int aaa = 3;
		for (int i = -aaa; i <= aaa; i++) {
			for (int j =-aaa; j <= aaa; j++) {
				System.out.print((Math.abs(i) + Math.abs(j) == aaa) ? "*" : " ");
			}
			System.out.println();
		}
	}
}
