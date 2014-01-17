package com.eoe.se1.day04;

import java.util.ArrayList;
import java.util.Iterator;

public class Test05 {
	public static void main(String[] args) {
		ArrayList_<Integer> scores = new ArrayList_<Integer>();
		scores.add(90);
		scores.add(100);
		scores.add(95);
		scores.add(89);
		scores.add(87);
		for(Integer score:scores){
			System.out.println(score);
		}
		System.out.println("********************");
		
		Iterator<Integer> iterator = scores.iterator();
		scores.ind();	
		while (iterator.hasNext()) {
			Integer score = iterator.next();
			System.out.println(score);
		}
	}
}
