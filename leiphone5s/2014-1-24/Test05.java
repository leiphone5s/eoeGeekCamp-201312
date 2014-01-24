package se2.day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) {
		String fileName = "D:\\se2\\day01\\java.txt";
		FileInputStream fis = null;
		int data;
		try {
			fis = new FileInputStream(fileName);
			while((data=fis.read())!=-1){
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
