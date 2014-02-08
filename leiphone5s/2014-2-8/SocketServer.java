package se2.day04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9991);
			System.out.println("等待客户端连接");
			Socket socket = server.accept();
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("发送第一行文本\t发送第二行文本");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
