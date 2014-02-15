package se2.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Test09 {
	private static String BASE_LINE = "http://localhost:8080/Se2_day10_06/Test001";

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("name=").append("’‘∑…∫Ë").append("&id=").append("1011")
				.append("&password=").append("123456").append("&phone=")
				.append("68337755").append("&email=").append("hfh@qq.com");
		BufferedReader reader = null;
		HttpURLConnection conn = null;
		try {
			byte[] data = sb.toString().getBytes("utf-8");
			URL url=new URL(BASE_LINE);
			conn=(HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", data.length + "");
			conn.getOutputStream().write(data);
			if (conn.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(
						conn.getInputStream(),"utf-8"));
				System.out.println(reader.readLine());
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
