package se2.day11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.eoe.se2.day10.entity.User;

public class Test01 {
	static final String SRC_PATH = "d:/se2/day03/";
	static final String FILENAME = "users1.xml";

	public static void main(String[] args) {
		InputStream in = null;
		try {
			ArrayList<User> users = null;
			User user = null;
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			in = new FileInputStream(SRC_PATH + FILENAME);
			parser.setInput(in, "utf-8");
			for (int type = parser.next(); type != XmlPullParser.END_DOCUMENT; type = parser
					.next()) {
				switch (type) {
				case XmlPullParser.START_TAG:
					String tag = parser.getName();
					if ("users".equals(tag)) {
						users = new ArrayList<User>();

					} else if ("user".equals(tag)) {
						user = new User();
						int id = Integer.parseInt(parser.getAttributeValue(0));
						user.setId(id);
					} else if ("name".equals(tag)) {
						user.setName(parser.nextText());
					} else if ("password".equals(tag)) {
						user.setPassword(parser.nextText());
					} else if ("phone".equals(tag)) {
						user.setPhone(parser.nextText());
					} else if ("email".equals(tag)) {
						user.setEmail(parser.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					if ("user".equals(parser.getName())) {
						users.add(user);
					} else if ("users".equals(parser.getName())) {
						for (User user2 : users) {
							System.out.println(user2);
						}
					}
					break;
				}
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
