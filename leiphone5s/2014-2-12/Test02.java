package se2.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Test02 {
public static void main(String[] args) {
	PrintWriter writer=null;
	BufferedReader reader=null;
	try {
		URL url=new URL("http://127.0.0.1/sources.rar");
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		writer=new PrintWriter("d://se2/day02/test01.rar");
		reader=new BufferedReader(new InputStreamReader(in,"gbk"));
		String line;
		while((line=reader.readLine())!=null){
			writer.println(line);
			writer.flush();
		}
		System.out.println("文件下载完成");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			if(writer!=null){
				writer.close();
			}
			if(reader!=null){
				reader.close();
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
