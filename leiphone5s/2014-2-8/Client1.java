package se2.day04;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream out = null;
		PrintWriter writer = null;
		try {
			for (int i = 0; i < 100; i++) {
				socket = new Socket("127.0.0.1", 11001);
				out = socket.getOutputStream();
				writer = new PrintWriter(out);
				writer.println("connect(i)=" + i);
				writer.flush();
				System.out.println("i=" + i);
				Thread.sleep(10);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (writer != null) {
				writer.close();
			}
		}
	}
}
