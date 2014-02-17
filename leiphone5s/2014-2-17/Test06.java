package se2.day10;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.apache.http.message.BasicNameValuePair;

public class Test06 {
	static final String BASE_LINE = "http://localhost:8080/Se2_day10_06/Test001";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_LINE);
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("name", "静夜思"));
		params.add(new BasicNameValuePair("id", "" + 35));
		params.add(new BasicNameValuePair("password", "123456789"));
		params.add(new BasicNameValuePair("phone", "63557788"));
		params.add(new BasicNameValuePair("email", "jys@qq.com"));
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,
					"utf-8");
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				InputStream in = response.getEntity().getContent();
				byte[] buffer = new byte[1024 * 10];
				in.read(buffer);
				String data = new String(buffer, "utf-8");
				System.out.println("返回信息:" + data);
			}
			for (BasicNameValuePair pair : params) {
				System.out.print(pair + "   ");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
