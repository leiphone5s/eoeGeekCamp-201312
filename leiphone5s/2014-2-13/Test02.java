package se2.day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {
	private static final String BASE_URL = "http://127.0.0.1/";;
	private static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";
	private static final String DEST_PATH = "d:/se2/day04";

	public static void main(String[] args) {
		FileOutputStream fos = null;
		HttpURLConnection connection = null;
		try {
			URL url = new URL(BASE_URL + FILENAME);
			connection = (HttpURLConnection) url.openConnection();
			connection.setReadTimeout(5000);
			connection.setConnectTimeout(5000);
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			InputStream in = connection.getInputStream();
			fos = new FileOutputStream(DEST_PATH + FILENAME);
			byte[] buffer = new byte[1024];
			int len;
			System.out.println(FILENAME + "正在下载...");
			while ((len = in.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			System.out.println(FILENAME + "下载完毕！");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				connection.disconnect();
			}

		}

	}
}
