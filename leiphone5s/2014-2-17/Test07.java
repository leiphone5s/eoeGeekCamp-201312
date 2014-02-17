package se2.day10;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Test07 {
	static final String BASE_LINE = "http://haoma.imobile.com.cn/index.php";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������ѯ���ֻ�����:");
		String mobile = scanner.next();
		HttpClient client = new DefaultHttpClient();
		String content = BASE_LINE + "?mob=" + mobile;
		HttpUriRequest request = new HttpGet(content);

		try {
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				String msg = EntityUtils.toString(entity);
				System.out.println(msg);
			}
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
