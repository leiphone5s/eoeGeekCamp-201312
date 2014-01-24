package se2.day04;

public class Test12 {
	public static void main(String[] args) {

		for (int i = 4; i >= -4; i--)// 控制行数
		{
			for (int j = 0; j < Math.abs(i) + 3; j++)
				System.out.print(" ");// 控制每行的的空格数,如果第5行前面不要空格,可以把+3去掉
			for (int j = 0; j < (5 - Math.abs(i)); j++)
				System.out.print("* ");// 控制每行*的个数

			System.out.println();// 换行
		}
	}

}
