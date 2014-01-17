package com.eoe.se1.day04;

import java.util.ArrayList;
import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
	String[] names={"a","bb","ccc","dddd",};
//	ArrayList<String> list=new ArrayList<String>();
//	copy(names,list);
//	System.out.println(Arrays.toString(names));
	Double[] scores={95.1,68.9,89.4,97.5};
	ArrayList<Double> list2=new ArrayList<Double>();
	copy(scores,list2);
}
static <T> void copy(T[] src,ArrayList<T> dest){
	for(T t:src){
		dest.add(t);
	}
	System.out.println(dest);
}
}

