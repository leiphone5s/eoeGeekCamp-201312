package com.eoe.se1.day04;

import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数:");
		int n = sc.nextInt();
		int[][] m = new int[n][n];
		rotating(n, m);
		print(n, m);

	}

	private static void print(int n, int[][] m) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%4d", m[i][j]);
			}
			System.out.println();
		}
	}

	private static void rotating(int n, int[][] m) {
		// TODO Auto-generated method stub
		int k = 1;
		for (int i = 0; i <= n / 2; i++) {
			for (int j = i; j < n - i; j++) {
				m[i][j] = k++; // 上方行方向
			}
			for (int j = i + 1; j < n - i; j++) {
				m[j][n - i - 1] = k++; // 右侧列方向
				
			}
			for (int j = n - i - 2; j >= i; j--) {
				m[n - i - 1][j] = k++; // 下方行方向
			}
			for (int j = n - i - 2; j > i; j--) {
				m[j][i] = k++; // 左侧列方向
			}
		}
	}

}