package se2.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		Socket socket = null;
		try {
			Scanner scanner = new Scanner(System.in);
			socket = new Socket("127.0.0.1", 10001);
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream());
			String answer = "";
			while (true) {
				System.out.println("ÎÊ:");
				String question = scanner.next();
				writer.println("Âò¼Ò:" + question);
				writer.flush();
				answer = reader.readLine();
				System.out.println(answer);
				if ("88".equals(question) && answer.indexOf("88") >= 0) {
					writer.println("88");
					writer.flush();
					break;
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
