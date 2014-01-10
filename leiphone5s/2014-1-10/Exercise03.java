package com.fengleiit.wow;

import java.util.Arrays;

public class Exercise03 {
	public static void main(String[] args) {
	int[] a={45,32,26,78,65};
	System.out.println(Arrays.toString(a));
	for(int i=1;i<a.length;i++){
		for(int j=0;j<a.length-i;j++){
			if(a[j]<a[j+1]){
				int temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
	}
	System.out.println(Arrays.toString(a));
	}
}
