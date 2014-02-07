package se2.day03;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test07 {
	public static void main(String[] args) {
		byte[] data = { 65, 66, 67 };
		System.out.println(Arrays.toString(data));
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		byte[] buffer = new byte[3];
		try {
			int len = bais.read(buffer);
			System.out.println(Arrays.toString(buffer));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
