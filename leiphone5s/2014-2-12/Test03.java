package se2.day07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import se2.day03.entity.User;

public class Test03 {
	static final String ADDRESS = "http://127.0.0.1/user.txt";
	static final String DEST_PATH = "d:/se2/day04";
	static final String DEST_FILENAME = "user.dat";

	public static void main(String[] args) {
		User[] users = new User[0];
		BufferedReader reader = null;
		ObjectOutputStream oos = null;
		try {
			URL url = new URL(ADDRESS);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				User user = parse(line);
				users = Arrays.copyOf(users, users.length + 1);
				users[users.length - 1] = user;
			}
			File dir = new File(DEST_PATH);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir, DEST_FILENAME);
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(users);
			System.out.println("œ¬‘ÿÕÍ±œ");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static User parse(String line) {
		User user = new User();
		String[] data = line.split(":");
		user.setId(Integer.parseInt(data[0]));
		user.setName(data[1]);
		user.setPassword(data[2]);

		return user;
	}
}
