package se2.day09;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Test13 {
	static final String BASE_LINE = "http://localhost:8080/Se2_day11/Test";

	public static void main(String[] args) {

		HttpURLConnection conn = null;

		try {
			StringBuilder sb = new StringBuilder(BASE_LINE);
			sb.append("?name=").append(URLEncoder.encode("¡ı“‡∑∆", "utf-8"));
			sb.append("&password=").append("123456");
			sb.append("&age=").append("25");
			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() != 200) {
				System.out.println("connection failure");
			}
			InputStream in = conn.getInputStream();
			byte[] data = new byte[1024 * 10];
			in.read(data);
			String response = new String(data, "utf-8");
			String response1 = new String(data, "utf-8");
			System.out.println("∑µªÿ–≈œ¢:" + response+response1);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
