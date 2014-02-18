package se2.day11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import com.eoe.se2.day10.entity.User;

public class Test04 {
	static final String DEST_PATH = "d:/se2/day04/";
	static final String FILENAME = "users3.xml";

	public static void main(String[] args) {
		ArrayList<User> users = initUsers();
		PrintWriter writer = null;
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlSerializer serializer = factory.newSerializer();
			writer = new PrintWriter(DEST_PATH + FILENAME);
			serializer.setOutput(writer);
			serializer.startDocument("utf-8", null);
			serializer.text("\n");
			serializer.startTag(null, "users");
			for (User user : users) {
				serializer.text("\t");
				serializer.text("\n");
				serializer.startTag(null, "user");
				serializer.attribute(null, "id", user.getId() + "");
				serializer.text("\n");
				serializer.text("\t");
				serializer.startTag(null, "name");
				serializer.text(user.getName());
				serializer.endTag(null, "name");
				serializer.text("\n");
				serializer.text("\t");
				serializer.startTag(null, "password");
				serializer.text(user.getPassword());
				serializer.endTag(null, "password");
				serializer.text("\n");
				serializer.text("\t");
				serializer.startTag(null, "phone");
				serializer.text(user.getPhone());
				serializer.endTag(null, "phone");
				serializer.text("\n");
				serializer.text("\t");
				serializer.startTag(null, "email");
				serializer.text(user.getEmail());
				serializer.endTag(null, "email");
				serializer.text("\n");
				serializer.endTag(null, "user");
			}
			serializer.text("\n");
			serializer.endTag(null, "users");
			serializer.endDocument();
			System.out.println(FILENAME + "生成完毕");
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	private static ArrayList<User> initUsers() {
		User user = new User();
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User(1001, "张飞", "12345", "68337799", "zf@qq.com"));
		list.add(new User(1002, "王飞", "12345", "68337799", "zf@qq.com"));
		list.add(new User(1003, "李飞", "12345", "68337799", "zf@qq.com"));
		list.add(new User(1004, "许飞", "12345", "68337799", "zf@qq.com"));
		list.add(new User(1005, "曲飞", "12345", "68337799", "zf@qq.com"));

		return list;
	}
}
