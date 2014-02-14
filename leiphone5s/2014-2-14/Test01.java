package se2.day09;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test01 {
public static void main(String[] args) {
	HttpURLConnection conn=null;
	try {
		URL url=new URL("http://localhost:8080/Se2_day09/Test01");
		conn=(HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(5000);
		conn.setDoInput(true);
		conn.setRequestMethod("GET");
		System.out.println(conn.getResponseMessage());
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(conn!=null){
			conn.disconnect();
		}
	}
}
}
