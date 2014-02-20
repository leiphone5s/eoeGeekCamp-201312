package com.eoe.se2.day12;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.eoe.se2.day10.entity.User;

public class Test09 {
	static final String BASE_LINE = "http://localhost:8080/Se2.day12_01/Test01";

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<>();
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_LINE);
		try {
			ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			params.add(new BasicNameValuePair("name", "∑∆"));
			post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200) {
				System.out.println("¡¨Ω” ß∞‹");
				return;
			}
			InputStream in = response.getEntity().getContent();
			XmlPullParser parser = XmlPullParserFactory.newInstance()
					.newPullParser();
			parser.setInput(in, "utf-8");
			User user;
			for (int type = XmlPullParser.START_DOCUMENT; type != XmlPullParser.END_DOCUMENT; type = parser
					.next()) {
				if (type == XmlPullParser.START_TAG) {
					if ("user".equals(parser.getName())) {
						user = new User();
						user.setId(Integer.parseInt(parser.getAttributeValue(0)));
						user.setName(parser.getAttributeValue(1));
						user.setPassword(parser.getAttributeValue(2));
						user.setPhone(parser.getAttributeValue(3));
						user.setEmail(parser.getAttributeValue(4));
						users.add(user);
					}
				}
			}
			for (User u : users) {
				System.out.println(u);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
