package se2.day04;

import java.io.File;
import java.util.Scanner;

public class Test01 {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int select;
	System.out.println("1-检测并创建文件夹");
	System.out.println("2-创建嵌套文件夹");
	System.out.println("3-创建文件");
	System.out.println("4-删除文件");
	System.out.println("select(1-4)");
	select=input.nextInt();
	switch(select){
	case 1://检测并创建文件夹
		File root=new File("d:/se1");
		if(!root.exists()){
			System.out.println("d:/se1不存在");
			root.mkdir();
		}else{
			System.out.println("d:/se1存在");
		}
		break;
	case 2://创建嵌套文件夹
		File root2=new File("d:/se2");
		File dir=new File(root2,"day01");
		if(!dir.exists()){
			if(dir.mkdirs()){
			System.out.println("d:/se2/day01文件夹创建成功");
		}else{
			System.out.println("d:/se2/day01文件夹创建失败");
		}
	}else{
		System.out.println("d:/se2/day01文件夹一存在");
	}
	break;
	case 3://创建文件
		File root3=new File("d:/se2");
		//File dir3
}
}
}
