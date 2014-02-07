package se2.day03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test04 {
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("d:/se2/day03/test01.txt", "rw");
			raf.write(255);
			raf.writeInt(1000);
			raf.writeUTF("’≈∑…");
			raf.writeChars("¡ı“‡∑∆");
			raf.seek(0);
			System.out.println(raf.read());
			System.out.println(raf.readInt());
			System.out.println(raf.readUTF());
			System.out.println(raf.readChar() + "" + raf.readChar()
					+ raf.readChar());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
