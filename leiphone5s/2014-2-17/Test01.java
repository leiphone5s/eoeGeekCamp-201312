package se2.day10;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test01 {
	static final String URL = "http://localhost:8080/Se2.day10_weekend01/Testweekend01?name=张飞&age=25";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(get);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().getReasonPhrase());
			System.out.println(response.getStatusLine().getProtocolVersion());
			InputStream in = response.getEntity().getContent();
			byte[] buffer=new byte[1024*10];
			in.read(buffer);
			String data=new String(buffer, "utf-8");
			System.out.println("返回信息:"+data);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}

	}
}
