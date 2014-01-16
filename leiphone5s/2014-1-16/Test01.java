package com.eoe.se1.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Test01 {
public static void main(String[] args) {
	ArrayList<Score> scores=new ArrayList<Score>();
	scores.add(new Score(98,28,35,64));
	scores.add(new Score(97,25,35,64));
	scores.add(new Score(97,24,35,64));
	scores.add(new Score(97,20,31,64));
	Collections.shuffle(scores,new Random());
	for(Score score:scores){
		System.out.println(score);
	}
	Collections.sort(scores,new MyComparator());
	System.out.println("*****************************");
	for(Score score:scores){
		System.out.println(score);
	}
	
}
static class MyComparator implements Comparator<Score>{

	@Override
	public int compare(Score o1,Score o2) {
	if(o1.java==o2.java){
	return o1.android-o2.android;	
	}
	return o1.java-o2.java;		
	}
	
}
}
