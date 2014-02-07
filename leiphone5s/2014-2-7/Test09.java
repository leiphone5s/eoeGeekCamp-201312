package se2.day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test09 {
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(65);
		baos.write(66);
		baos.write(67);
		byte[] data = baos.toByteArray();
		System.out.println(Arrays.toString(data));
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		byte[] buffer = new byte[3];
		try {
			bais.read(buffer);
			System.out.println(Arrays.toString(buffer));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
