package se2.day06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import se2.day05.FileInfo;

public class UploadServer {
	static final String DEST_PATH = "d:/se2/day04/";

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(Runtime
				.getRuntime().availableProcessors());
		try {
			ServerSocket server = new ServerSocket(9999);
			System.out.println("等待客户端连接...");
			while (true) {
				Socket socket = server.accept();
				pool.execute(new UploadTask(socket));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class UploadTask implements Runnable {
		Socket socket;

		public UploadTask(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			System.out.println("正在上传...");
			FileOutputStream fos = null;
			ObjectInputStream ois = null;
			try {
				InputStream in = socket.getInputStream();
				ois = new ObjectInputStream(in);
				FileInfo info = (FileInfo) ois.readObject();
				fos = new FileOutputStream(DEST_PATH + info.getFileName());
				int len;
				byte[] buffer = new byte[1024];

				while ((len = in.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				System.out.println(info.getFileName() + "上传完毕");
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
					if (fos != null) {
						fos.close();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
