package se2.day10;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test02 {
	static final String URL = "http://localhost:8080/Se2.day10_weekend01/Testweekend01?name=уе╥и&age=25";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		try {
			HttpGet get = new HttpGet(URL);
			HttpResponse response = client.execute(get);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().getReasonPhrase());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
