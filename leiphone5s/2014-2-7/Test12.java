package se2.day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import se2.day03.entity.User;

public class Test12 {
	public static void main(String[] args) {
		User user = new User(1001, "уе╥и", "123456");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(user);
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			ois = new ObjectInputStream(bais);
			User user1 = (User) ois.readObject();
			System.out.println(user1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
