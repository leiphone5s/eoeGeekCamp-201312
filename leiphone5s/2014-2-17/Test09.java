package se2.day10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.sql.Savepoint;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

public class Test09 {
	static final String BASE_LINE = "http://127.0.0.1/adt-bundle-windows-x86_64-20130522.zip";
	static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";
	static final String RECORD_FILENAME = "record.dat";
	static final String DEST_PATH = "d:/se2/day04/";
	static boolean isContinue = true;

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("�������ֹͣ����");
				new Scanner(System.in).next();
				isContinue = false;
			};
		}.start();
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_LINE);
		long position = readRecord();
		post.addHeader(new BasicHeader("Range", "bytes=" + position + "-"));
		RandomAccessFile raf = null;
		try {
			HttpResponse response = client.execute(post);
			int code = response.getStatusLine().getStatusCode();
			if (code != 200 && code != 206) {
				System.out.println("����ʧ��");
				return;
			}

			raf = new RandomAccessFile(DEST_PATH + FILENAME, "rw");
			InputStream in = response.getEntity().getContent();
			int len;
			byte[] buffer = new byte[1024 * 1];
			raf.seek(position);
			long start=System.currentTimeMillis();
			System.out.println(FILENAME + "����������...");
			while ((len = in.read(buffer)) != -1 && isContinue) {
				raf.write(buffer, 0, len);
				position += len;
			}
			long end=System.currentTimeMillis();
			System.out.println("����ʱ��:"+(end-start));
			if (isContinue) {
				position = 0;
				saveRecord(0);
				System.out.println(FILENAME + "�������!");
				File file = new File(DEST_PATH + RECORD_FILENAME);
				if (file.exists()) {
					file.delete();
				}
				System.exit(0);
			} else {
				saveRecord(position);
				System.out.println(FILENAME + "���ر���ֹ!!!");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
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

	static long readRecord() {
		long position = 0;
		DataInputStream dis = null;
		File file = new File(DEST_PATH + RECORD_FILENAME);
		if (!file.exists()) {
			return 0;
		}
		try {
			dis = new DataInputStream(new FileInputStream(file));
			position = dis.readLong();
			return position;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	static void saveRecord(long position) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(DEST_PATH
					+ RECORD_FILENAME));
			dos.writeLong(position);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
