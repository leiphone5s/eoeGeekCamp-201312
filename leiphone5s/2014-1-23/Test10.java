package se1.day04;

import java.text.DecimalFormat;

public class Test10 {
	public static void main(String[] args) {
		/*DecimalFormat df=new DecimalFormat("$000,000.##");
		double d=1000000.75;
		//d=df.parse(text).doubleValue();
		String text=df.format(d);
		System.out.println(text);*/
		String regex="[a-z:/,]";
		String text="answer:A/B/C,level:10,score:2";
		String  data=text.replaceAll(regex, " ").trim();
		System.out.println(data);
}
}