package com.fengleiit.wow;

import java.util.Arrays;

public class Exercise04 {
	public static void main(String[] args) {
		int[] a={45,32,26,78,65};
		System.out.println(Arrays.toString(a));
		int k;
		for(int i=0;i<a.length;i++){
			k=a[i];
			int j;
			for(j=i-1;j>=0&&k>a[j];j--){
				a[j+1]=a[j];
			}
			a[j+1]=k;
		}
		System.out.println(Arrays.toString(a));
	}
}
