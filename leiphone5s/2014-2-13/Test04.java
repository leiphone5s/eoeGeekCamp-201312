package se2.day08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import se2.day07.Record;

public class Test04 {
	private static final String BASE_URL = "http://127.0.0.1/";;
	private static final String DEST_PATH = "d:/se2/day04/";
	private static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";
	private static final String RECORD_FILENAME = "record.dat";
	private static int THREAD_COUNT = 3;
	private static boolean isContinue = true;
	private static Record[] records;
	private static int BUF_SIZE = 1024;

	public static void main(String[] args) {
		final ExecutorService pool = Executors
				.newFixedThreadPool(THREAD_COUNT + 1);
		pool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("按任意键停止下载");
				new Scanner(System.in).next();
				isContinue = false;
				pool.shutdown();

			}
		});
		if (!readRecord()) {
			long fileSize = requestFileSize();
			long blockSize = fileSize / THREAD_COUNT;
			for (int i = 0; i < records.length; i++) {
				records[i] = new Record();
				records[i].setFileName(FILENAME);
				records[i].setStartPos(i * blockSize);
				records[i].setEndPos((i + 1) * blockSize - 1);
			}
			records[records.length - 1].setEndPos(fileSize - 1);
		}
		for (int i = 0; i < records.length; i++) {
			pool.execute(new DownloadTask(i));
		}
	}

	static class DownloadTask implements Runnable {
		int threadi;

		public DownloadTask(int threadi) {
			this.threadi = threadi;
		}

		@Override
		public void run() {
			RandomAccessFile raf = null;
			HttpURLConnection conn = null;
			try {
				URL url = new URL(BASE_URL + FILENAME);
				conn = (HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(5000);
				conn.setReadTimeout(5000);
				conn.setRequestMethod("GET");
				conn.setDoInput(true);
				long start = records[threadi].getStartPos();
				long end = records[threadi].getEndPos();
				conn.setRequestProperty("Range", "bytes=" + start + "-" + end);
				InputStream in = conn.getInputStream();
				int responseCode = conn.getResponseCode();
				if (responseCode != 200 && responseCode != 206) {
					System.out.println(conn.getResponseMessage());
					return;
				}
				raf = new RandomAccessFile(DEST_PATH + FILENAME, "rw");
				raf.seek(start);
				byte[] buffer = new byte[BUF_SIZE];
				int len;
				while (start < end && isContinue) {
					len = in.read(buffer);
					raf.write(buffer, 0, len);
					start += len;
					records[threadi].setStartPos(start);
				}
				if (isContinue) {
					System.out.println("第" + (threadi + 1) + "块下载完成！");
				} else {
					saveRecord();
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
				if (conn != null) {
					conn.disconnect();
				}
				int count = 0;
				for (Record record : records) {
					if (record.getStartPos() >= record.getEndPos()) {
						count++;
					}
				}
				if (count == THREAD_COUNT) {
					System.out.println(FILENAME + "下载完成！！！");
					File file = new File(DEST_PATH + RECORD_FILENAME);
					if (file.exists()) {
						file.delete();
					}
				}
			}

		}

	}

	static long requestFileSize() {
		HttpURLConnection conn = null;
		try {
			URL url = new URL(BASE_URL + FILENAME);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			InputStream in = conn.getInputStream();
			if (conn.getResponseCode() != 200) {
				System.out.println(conn.getResponseMessage());
				return 0;
			}
			long fileSize = conn.getContentLength();
			return fileSize;
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
		return 0;

	}

	static boolean readRecord() {
		File file = new File(DEST_PATH + RECORD_FILENAME);
		if (!file.exists()) {
			records = new Record[THREAD_COUNT];
			return false;
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			records = (Record[]) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
		}
		return true;
	}

	static void saveRecord() {
		ObjectOutputStream oos = null;
		File file = new File(DEST_PATH + RECORD_FILENAME);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(records);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
