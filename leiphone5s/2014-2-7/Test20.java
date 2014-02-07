package se2.day03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test20 {
	static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";
	static final String SRC_PATH = "d:/se2/day03";
	static final String DEST_PAHT = "d:/se2/day04";
	static final String RECORD_FILENAME = "record.txt";
	static int position;

	static enum Action {
		READY, DOWNLAODING, STOP;
	}

	static Action action;

	public static void main(String[] args) {
		action = Action.READY;
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
			};
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
			}
			System.out.println("下载中......");
			File src = new File(SRC_PATH, FILENAME);
			File dest = new File(DEST_PAHT, FILENAME);
			RandomAccessFile in = null;
			RandomAccessFile out = null;
			try {
				in = new RandomAccessFile(src, "r");
				out = new RandomAccessFile(dest, "rw");
				int position = readLocation();
				in.seek(position);
				out.seek(position);
				int len;
				byte[] buffer = new byte[1024];
				while ((len = in.read(buffer)) != -1 && action != Action.STOP) {
					out.write(buffer, 0, len);
					position += len;
				}
				if (action == action.DOWNLAODING) {
					System.out.println("下载结束");
					position = 0;
				}
				saveLocation(position);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (null != in) {
						in.close();
					}
					if (null != out) {
						out.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		private int readLocation() {
			int position = 0;
			boolean isExists = true;
			File file = new File(DEST_PAHT, RECORD_FILENAME);
			try {
				isExists = file.exists();
				DataInputStream in = null;
				DataOutputStream out = null;
				if (isExists) {
					in = new DataInputStream(new FileInputStream(file));
					position = in.readInt();
				} else {
					out = new DataOutputStream(new FileOutputStream(file));
					out.writeInt(0);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return position;
		}

		static void saveLocation(int pos) {
			File file = new File(DEST_PAHT, RECORD_FILENAME);
			FileOutputStream fos = null;
			DataOutputStream out = null;
			try {
				fos = new FileOutputStream(file);
				out = new DataOutputStream(fos);
				out.writeInt(pos);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (null != out) {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
