package se2.day09;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Test02 {
	static final String BASE_URL = "http://localhost:8080/Se2_day09/Test01";

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		HttpURLConnection conn = null;
		try {
			sb.append("?name=").append(URLEncoder.encode("уе╥и", "utf-8"));
			URL url = new URL(BASE_URL + sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			InputStream in = conn.getInputStream();
			System.out.println(conn.getResponseMessage());
			if (conn.getResponseCode() != 200) {
				return;
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
