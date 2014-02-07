package se2.day03;

import java.io.Serializable;
import java.util.ArrayList;

import se2.day03.entity.User;

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	public ArrayList<User> listUser;

	public Users() {
		listUser = new ArrayList<User>();
	}
}
