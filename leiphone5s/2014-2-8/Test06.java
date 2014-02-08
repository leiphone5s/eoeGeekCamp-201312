package se2.day04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test06 {
	private static final String SRC_PATH = "d:/se2/day03/";
	private static final String DEST_PATH = "d:/se2/day04/";
	private static final String FILE_NAME = "adt-bundle-windows-x86_64-20130522.zip";
	static final String RECORD_FILE_NAME = "record.dat";

	enum Action {
		READY, DOWNING, STOP
	}

	static Action action;

	public static void main(String[] args) {
		action = Action.READY;// 表示准备下载
		final DownloadTask downloadTask = new DownloadTask();
		downloadTask.start();
		Thread controllThread = new Thread() {
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				while (true) {
					System.out.println("1-开始下载\t2-停止下载");
					int select = scanner.nextInt();
					action = Action.values()[select];
					synchronized (downloadTask) {
						downloadTask.notify();
					}
				}
			}
		};
		controllThread.setDaemon(true);
		controllThread.start();
	}

	static class DownloadTask extends Thread {
		@Override
		public void run() {
			if (action == Action.READY) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				action = Action.DOWNING;
				long pos = readLocation();
				RandomAccessFile srcRaf = null;
				RandomAccessFile destRaf = null;
				System.out.println("正在下载......");
				try {
					srcRaf = new RandomAccessFile(SRC_PATH + FILE_NAME, "r");
					destRaf = new RandomAccessFile(DEST_PATH + FILE_NAME, "rw");
					srcRaf.seek(pos);
					destRaf.seek(pos);
					byte[] buffer = new byte[1024*10];
					long startTime=System.currentTimeMillis();
					int len;
					while ((len = srcRaf.read(buffer)) != -1
							&& action == Action.DOWNING) {
						destRaf.write(buffer, 0, len);
						pos += len;
					}
					long endTime=System.currentTimeMillis();
					long cost=(endTime-startTime);
					System.out.println("耗时"+cost+"秒");
					if (action == Action.DOWNING) {
						pos = 0;
						saveLocation(pos);
						System.out.println("文件下载完毕");
					} else {
						System.out.println("下载被终止");
						saveLocation(pos);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (srcRaf != null) {
							srcRaf.close();
						}
						if (destRaf != null) {
							destRaf.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		private void saveLocation(long pos) {
			DataOutputStream dos = null;
			try {
				File file = new File(SRC_PATH, RECORD_FILE_NAME);
				dos = new DataOutputStream(new FileOutputStream(file));
				dos.writeLong(pos);
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

		private long readLocation() {
			long pos = 0;
			DataOutputStream dos = null;
			DataInputStream dis = null;
			File file = new File(SRC_PATH, RECORD_FILE_NAME);
			try {
				if (!file.exists()) {
					file.createNewFile();
					dos = new DataOutputStream(new FileOutputStream(file));
					dos.writeLong(0);
				} else {
					dis = new DataInputStream(new FileInputStream(file));
					pos = dis.readLong();
				}
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
					if (dis != null) {
						dis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return pos;
		}
	}
}
