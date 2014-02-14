package se2.day09;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.eoe.se2.day10.entity.User;

public class Test04 {
	static final String BASE_LINE = "http://localhost:8080/Se2_day10_01/Test01";

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("name=").append("¡ı“‡∑∆").append("&password=").append("1234");
		HttpURLConnection conn = null;
		ObjectInputStream ois = null;
		try {
			byte[] data = sb.toString().getBytes("utf-8");
			URL url = new URL(BASE_LINE);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", data.length + "");
			OutputStream out = conn.getOutputStream();
			out.write(data);
			if (conn.getResponseCode() == 200) {
				ois = new ObjectInputStream(conn.getInputStream());
				User user = (User) ois.readObject();
				System.out.println(user);
			} else {
				System.out.println("¡¨Ω” ß∞‹£°£°£°");
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
