package se2.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadServer {
	private static final String SRC_PATH = "d:/se2/day03/";
	private static final int PORT = 9999;

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(Runtime
				.getRuntime().availableProcessors());
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("等待客户端发送下载的文件名...");
			while (true) {
				Socket socket = server.accept();
				Record record = responseClient(socket);
				if (record != null) {
					pool.execute(new DownloadTask(socket, record));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Record responseClient(Socket socket) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			RecordInfo info = (RecordInfo) ois.readObject();
			if ("download".equals(info.getRequestType())) {
				return info.getRecord();
			}
			if ("filename".equals(info.getRequestType())) {
				FileInputStream fis = new FileInputStream(SRC_PATH
						+ info.getRecord().getFileName());
				// 获取文件长度
				int fileSize = fis.available();
				// 保存在info对象中
				info.setFileSize(fileSize);
				// 创建对象输出流
				ObjectOutputStream oos = new ObjectOutputStream(
						socket.getOutputStream());
				oos.writeObject(info);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	static class DownloadTask implements Runnable {
		Socket socket;
		Record record;
		final int BUF_SIZE = 10 * 1024;

		public DownloadTask(Socket socket, Record record) {
			this.socket = socket;
			this.record = record;
		}

		@Override
		public void run() {
			RandomAccessFile raf = null;
			try {
				OutputStream out = socket.getOutputStream();
				raf = new RandomAccessFile(SRC_PATH + record.getFileName(), "r");
				long start = record.getStartPos();
				long end = record.getEndPos();
				raf.seek(start);
				byte[] buffer = new byte[BUF_SIZE];
				int len;
				while ((len = raf.read(buffer)) != -1 && start < end) {
					out.write(buffer, 0, len);
					start += len;
				}
			}catch(SocketException e){
				
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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

	}
}
