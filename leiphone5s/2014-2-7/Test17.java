package se2.day03;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class Test17 {
	public static void main(String[] args) {
		String expression = "if(a==5) {b=3;}";
		byte[] data = expression.getBytes();
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		System.out.println(expression);
		PushbackInputStream pis = null;
		pis = new PushbackInputStream(bais, 4);
		int c;
		try {
			while ((c = pis.read()) != -1) {
				if (c == '{') {
					pis.unread('\n');
				}
				if (c == '}') {
					System.out.println();
				}
				if (c == '\n') {
					byte space = (byte) ' ';
					byte[] b = { space, space, space, space };
					pis.unread(b);
				}
				System.out.print((char)c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pis != null) {
				try {
					pis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
