package se2.day10;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.eoe.se2.day10.entity.User;

public class Test03 {
static final String BASE_LINE="http://localhost:8080/Se2_day10_06/Test001";
public static void main(String[] args) {
	StringBuilder sb=new StringBuilder(BASE_LINE);
	sb.append("?name=").append("刘非")
	  .append("&id=").append("1020")
	  .append("&password=").append("123456")
	  .append("&phone=").append("68997766")
	  .append("&email=").append("lifei@qq.com");
	HttpClient client=new DefaultHttpClient();
	HttpGet get=new HttpGet(sb.toString());
	ObjectInputStream ois=null;
	try {
		HttpResponse response=client.execute(get);
		InputStream in=response.getEntity().getContent();
		ois=new ObjectInputStream(in);
		
		User user=(User) ois.readObject();
		System.out.println(user);
		byte[] buffer=new byte[1024];
		in.read(buffer);
		String data=new String(buffer, "utf-8");
		System.out.println("返回信息:"+data);
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(ois!=null){
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}
