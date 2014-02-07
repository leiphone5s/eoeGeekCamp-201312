package se2.day03;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Test08 {
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(65);
		baos.write(66);
		baos.write(66);
		byte[] data = baos.toByteArray();
		System.out.println(Arrays.toString(data));
	}
}
