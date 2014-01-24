package se2.day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test09 {
public static void main(String[] args) {
	FileInputStream fis=null;
	try {
		fis=new FileInputStream("d:/se2/day03");
		int data=fis.read();//读取65
		System.out.println(data);
		data=fis.read();
		System.out.println(data);
		data=fis.read();
		System.out.println("中的高8位:"+Integer.toHexString(data));
		int data2=fis.read();//读取0x2d
		System.out.println("中的低8位:"+Integer.toHexString(data2));
		int data3=data<<8|data2;
		System.out.println((char)data3+":"+data3);
		System.out.println("\t\t0x"+Integer.toHexString(data3));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
