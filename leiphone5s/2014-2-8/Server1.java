package se2.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		BufferedReader reader=null;
		PrintWriter writer=null;
		ServerSocket server=null;
		try {
			server=new ServerSocket(11001,3);
			while(true){
				System.out.println("等待客户访问...");
				Socket socket=server.accept();
				reader=new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				writer=new PrintWriter(socket.getOutputStream());
				String question=reader.readLine();
				System.out.println(question);
				new Scanner(System.in).next();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(server!=null){
					server.close();
				}
				if(reader!=null){
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
