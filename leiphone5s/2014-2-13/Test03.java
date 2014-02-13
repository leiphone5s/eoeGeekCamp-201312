package se2.day08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Test03 {
	private static final String BASE_URL = "http://127.0.0.1/";
	private static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";
	private static final String DEST_PATH = "d:/se2/day04";
	private static final String RECORD_FILENAME = "record.dat";
	static boolean isContinue = true;

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("按任意键停止下载");
				new Scanner(System.in).next();
				isContinue = false;
			};
		}.start();
		RandomAccessFile raf = null;
		try {
			URL url = new URL(BASE_URL + FILENAME);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(3000);
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			long position = readPosition();
			connection.setRequestProperty("Range", "bytes=" + position);
			InputStream in = connection.getInputStream();
			raf = new RandomAccessFile(DEST_PATH + FILENAME, "rw");
			raf.seek(position);
			int len;
			byte[] buffer = new byte[1024*10];
			System.out.println(FILENAME+"正在下载...");
			while ((len = in.read(buffer)) != -1) {
				raf.write(buffer, 0, len);
			}
			if (!isContinue) {
				savePosition(position);
				System.out.println(FILENAME + "下载被终止");
			} else {
				System.out.println(FILENAME + "下载完成");
				File file = new File(DEST_PATH + RECORD_FILENAME);
				if (file.exists()) {
					file.delete();
				}
			}
		} catch (MalformedURLException e) {
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
		}

	}

	static void savePosition(long position) {
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
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static long readPosition() {
		long position = 0;
		DataInputStream dis = null;
		File file = new File(DEST_PATH + RECORD_FILENAME);
		if (!file.exists()) {
			return 0;
		}
		try {
			dis = new DataInputStream(new FileInputStream(file));
			position = dis.readLong();
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
		return position;

	}
}
