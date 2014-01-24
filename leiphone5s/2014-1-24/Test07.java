package se2.day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test07 {
	public static void main(String[] args) {
		String srcFile = "D:/se2/day01/java.txt";
		String destFile = "D:/se2/day02/13.txt";
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(srcFile);
			fos=new FileOutputStream(destFile);
			byte[] data=new byte[1024*2];

			for(int len;(len=fis.read(data))!=-1;){
				fos.write(data, 0, len);
			}
			System.out.println("文件复制成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}finally{
		try {
			if(fis!=null){
				fis.close();
			}
			if(fos!=null){
				fos.close();
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
