package se2.day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadClient1 {
	private static final String DEST_PATH = "d:/se2/day04/";
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 9999;
	private static final int BUF_SIZE = 1024 * 10;
	private static boolean isContinue = true;
	private static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";
	private static final String RECORD_FILENAME = "test02.dat";
	private static final int THREAD_COUNT = 3;
	private static Record[] records;

	public static void main(String[] args) {
		final ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		pool.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("按任意键停止下载");
				new Scanner(System.in).next();
				isContinue = false;
				System.out.println("文件下载被终止...");
				//System.exit(0);
				pool.shutdown();
			}
		});
		if (!readRecord()) {
			requestServer();
		}
		for (int i = 0; i < records.length; i++) {
			pool.execute(new DownloadTask(records[i], i));
		}
	}

	 static boolean readRecord() {
		ObjectInputStream ois = null;
		try {
			File file = new File(DEST_PATH + RECORD_FILENAME);
			if (!file.exists()) {
				records = new Record[THREAD_COUNT];
				return false;
			}
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

	private static void requestServer() {
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			socket = new Socket(HOST, PORT);
			RecordInfo info = new RecordInfo();
			info.setRequestType("filename");
			info.getRecord().setFileName(FILENAME);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(info);
			ois = new ObjectInputStream(socket.getInputStream());
			info = (RecordInfo) ois.readObject();
			long blockSize = info.getFileSize() / THREAD_COUNT;
			for (int i = 0; i < records.length; i++) {
				records[i] = new Record();
				records[i].setFileName(FILENAME);
				records[i].setStartPos(i * blockSize);
				records[i].setEndPos((i + 1) * (blockSize) - 1);
			}
			records[records.length - 1].setEndPos(info.getFileSize() - 1);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (oos != null) {
					oos.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class DownloadTask implements Runnable {
		Record record;
		int treadi;// 块的索引值，线程的索引值

		public DownloadTask(Record record, int treadi) {
			super();
			this.record = record;
			this.treadi = treadi;
		}

		@Override
		public void run() {
			ObjectOutputStream oos = null;
			RandomAccessFile raf = null;
			Socket socket = null;
			try {
				socket = new Socket(HOST, PORT);
				oos = new ObjectOutputStream(socket.getOutputStream());
				RecordInfo info = new RecordInfo();
				info.setRecord(record);
				info.setRequestType("download");
				oos.writeObject(info);
				raf = new RandomAccessFile(DEST_PATH + FILENAME, "rw");
				long start = record.getStartPos();
				long end = record.getEndPos();
				raf.seek(start);
				byte[] buffer = new byte[BUF_SIZE];
				int len;
				InputStream in = socket.getInputStream();
				while (start < end && isContinue) {
					len = in.read(buffer);
					raf.write(buffer, 0, len);
					start += len;
					record.setStartPos(start);
				}
				saveRecord();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					if (oos != null) {
						oos.close();
					}
					if (raf != null) {
						raf.close();
					}
					if (socket != null) {
						socket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int count = 0;
				for (Record record : records) {
					if (record.getStartPos() >= record.getEndPos()) {
						count++;
					}
				}
				if (count == THREAD_COUNT) {
					System.out.println(FILENAME + "下载完毕");
					File file = new File(DEST_PATH + RECORD_FILENAME);
					if (file.exists()) {
						file.delete();
						
					}
				}
			}

		}

		static void saveRecord() {
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(DEST_PATH
						+ RECORD_FILENAME));
				oos.writeObject(records);
			} catch (FileNotFoundException e) {
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

}
