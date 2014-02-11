package se2.day06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.Scanner;

import se2.day05.FileInfo;

public class CopyOfDownloadClient2 {
	static final String DEST_PATH = "d:/se2/day04/";
	static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";
	static final String RECORD_FILENAME = "test03.txt";
	static boolean isContinue = true;

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("按任意键终止下载");
				new Scanner(System.in).next();
				isContinue = false;
			};
		}.start();
		Socket socket = null;
		RandomAccessFile raf = null;
		ObjectOutputStream oos = null;
		try {
			long position = readPosition();
			socket = new Socket("127.0.0.1", 9999);
			oos = new ObjectOutputStream(socket.getOutputStream());
			FileInfo info = new FileInfo(FILENAME, position);
			oos.writeObject(info);
			OutputStream out = socket.getOutputStream();
			raf = new RandomAccessFile(DEST_PATH + FILENAME, "r");
			raf.seek(position);
			int len;
			byte[] buffer = new byte[1024*10];
			System.out.println(FILENAME+"正在上传...");
			while ((len = raf.read(buffer)) != -1&&isContinue) {
				out.write(buffer, 0, len);
				position += len;
			}
			position = isContinue ? 0 : position;
			savePosition(position);
			if (isContinue) {
				System.out.println("文件上传完毕！");
				
			} else {
				System.out.println("文件下载被终止！！！");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
			System.exit(0);
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
			if (dos != null)
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	static long readPosition() {
		long position = 0;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		File file = new File(DEST_PATH, RECORD_FILENAME);
		try {
			if (!file.exists()) {
				file.createNewFile();
				dos = new DataOutputStream(new FileOutputStream(file));
				dos.writeLong(position);
			} else {
				dis = new DataInputStream(new FileInputStream(file));
				dis.readLong();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return position;

	}
}
