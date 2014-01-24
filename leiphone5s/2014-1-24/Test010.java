package se2.day04;

public class Test010 {
	/*
	 * int aaa=2;//这里设置菱形大小 for(int i=-aaa;i<=aaa;i++) //代表Y轴 { for(int
	 * j=-aaa;j<=aaa;j++) //代表X轴 {
	 * System.out.print((Math.abs(i)+Math.abs(j)<=aaa)?"*":" ");//要打空心<=该成== }
	 * System.out.println();//换行 }
	 */
	public static void main(String[] args) {

		int aaa = 5; // 设置单元菱形
		int bbb = 2;// 设置大菱形
		for (int b = -bbb; b <= bbb; b++) {   
			for (int i = -aaa; i <= aaa; i++) // 代表Y轴
			{
				for (int a = -bbb; a <= bbb; a++) {
					for (int j = -aaa; j <= aaa; j++) // 代表X轴
					{
						System.out.print((Math.abs(i) + Math.abs(j) <= aaa && 
								Math.abs(a) + Math.abs(b) <= bbb) ? "*": " ");
					}
				}
				System.out.println();// 换行
			}
		}
	}
}
