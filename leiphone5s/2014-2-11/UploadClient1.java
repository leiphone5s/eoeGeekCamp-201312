package se2.day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import se2.day05.FileInfo;

public class UploadClient1 {
	static final String SRC_PATH = "d:/se2/day03/";
	static final String FILENAME = "adt-bundle-windows-x86_64-20130522.zip";

	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectOutputStream oos = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9999);
			OutputStream out = socket.getOutputStream();
			FileInfo info = new FileInfo(FILENAME);
			oos = new ObjectOutputStream(out);
			oos.writeObject(info);
			fis = new FileInputStream(SRC_PATH + FILENAME);
			int len;
			byte[] buffer = new byte[1024];
			while ((len = fis.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
