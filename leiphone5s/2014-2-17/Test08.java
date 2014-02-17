package se2.day10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test08 {
	static final String BASE_LINE = "http://127.0.0.1/adt-bundle-windows-x86_64-20130522.zip";
	static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";
	static final String DEST_PATH = "d:/se2/day04/";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(BASE_LINE);
		FileOutputStream fos = null;
		try {
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
				fos = new FileOutputStream(DEST_PATH+FILENAME);
				InputStream in = response.getEntity().getContent();
				int len;
				byte[] buffer = new byte[1024 * 10];
				System.out.println(FILENAME + "正在下载中...");
				while ((len = in.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				System.out.println(FILENAME + "下载完成！");
			}
		} catch (ClientProtocolException e) {
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
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}

	}
}
