package se2.day10;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Test04 {
	static final String BASE_LINE = "http://localhost:8080/Se2.day10_weekend01/Testweekend01";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_LINE);
		try {
			List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			BasicNameValuePair param = new BasicNameValuePair("name", "¡ı“‡∑∆");
			params.add(param);
			param = new BasicNameValuePair("age", "" + 35);
			params.add(param);
			HttpEntity entity = new UrlEncodedFormEntity(params, "utf-8");
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().getReasonPhrase());
			byte[] buffer=new byte[1024*10];
			InputStream in=response.getEntity().getContent();
			in.read(buffer);
			String data=new String(buffer,"utf-8");
			System.out.println("∑µªÿ–≈œ¢:"+data);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
