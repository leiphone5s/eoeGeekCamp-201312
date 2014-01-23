package se1.day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test06 {
	public static void main(String[] args) {
		String text="father and mother,we are family,";
		text+="grand father and grand mother we are family";
		HashMap<Character, Integer> counts=new HashMap<Character, Integer>();
		for(int i=0;i<text.length();i++){
			char c=text.charAt(i);
			Integer count=counts.get(c);
			count=count==null?1:count+1;
			counts.put(c, count);
		}
		Set<Entry<Character, Integer>> entrys=counts.entrySet();
		ArrayList<Entry<Character, Integer>> list=
				new ArrayList<Map.Entry<Character,Integer>>(entrys);
		Collections.sort(list,new Comparator<Entry<Character,Integer>>(){

			@Override
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {

				return o2.getValue()-o1.getValue();
			}
			
	});
		for(Entry<Character,Integer> entry:list){
			System.out.println(entry.getKey()+"\t\t"+entry.getValue());
		}
}
}