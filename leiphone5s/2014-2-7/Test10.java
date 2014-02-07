package se2.day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test10 {
	public static void main(String[] args) {
		String name = "ÕÅ·É";
		char sex = 'ÄÐ';
		int age = 33;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		dos = new DataOutputStream(baos);
		try {
			dos.writeUTF(name);
			dos.writeChar(sex);
			dos.writeInt(age);
			byte[] data = baos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
			dis = new DataInputStream(bais);
			String name2 = dis.readUTF();
			char sex2 = dis.readChar();
			int age2 = dis.readInt();
			System.out.println(name2 + "\t" + sex2 + "\t" + age2);
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
	}
}
