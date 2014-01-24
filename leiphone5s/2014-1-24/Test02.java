package se2.day04;

import java.util.Scanner;

public class Test02 {
	static final byte BYTE=1;//0001
	static final byte KB=2;  //0010
	static final byte MB=4;  //0100
	static final byte GB=8;  //1000
	static final byte TB=16; //10000
public static void main(String[] args) {
	System.out.println("输入文件的大小(单位:字节)");
	long size=new Scanner(System.in).nextLong();
	String text=fileSize(size,BYTE|KB|MB|GB|TB);
	System.out.println(text);
}
private static String fileSize(long size, int mode) {
	if(mode==(BYTE|KB|MB|GB|TB)){
		if(size<1024){
			return size+"byte";
		}else if(size<1<<20){
			return size/1024.0+"kb";
		}else if(size<1<<30){
			return size/(1<<20)+"mb";
		}else if(size<1<<40){
			return size/(1<<30)+"gb";
		}else if(size<1<<50){
			return size/(1<<40)+"tb";
		}
	}
	if(mode==BYTE){
		return size+"byte";
	}
	if(mode==KB){
		return size/(1<<10)+"kb";
	}
	if(mode==MB){
		return size/(1<<20)+"mb";
	}
	if(mode==GB){
		return size/(1<<30)+"gb";
	}
	return null;
}
}
