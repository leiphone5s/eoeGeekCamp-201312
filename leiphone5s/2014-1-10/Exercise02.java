package com.fengleiit.wow;

import java.util.Arrays;
//√∞≈›≈≈–Ú∑®
public class Exercise02 {
	public static void main(String[] args) {
		int[] a={45,32,26,78,65};
		for(int i=0;i<a.length;i++){
		for(int j=i+1;j<a.length;j++){
			if(a[i]<a[j]){
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		System.out.println(Arrays.toString(a));
		}
	}
}
