package se1.day04;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;

public class Test08 {
public static void main(String[] args){
	/*DecimalFormat df=new DecimalFormat("0.##%");
	double d=0.755;
	System.out.println(d);
	String text=df.format(d);
	System.out.println(text);*/
	/*String text="5.56%";
	double d=df.parse(text).doubleValue();
	System.out.println(d);
	d=0.852;
	text=df.format(d);
	System.out.println(text);
	df.applyPattern("000,000,##");
	text=df.format(150063);
	System.out.println(text);*/
	int[] m=new int[]{12,13,45,89};
	System.out.println(Arrays.toString(m));
}
}
