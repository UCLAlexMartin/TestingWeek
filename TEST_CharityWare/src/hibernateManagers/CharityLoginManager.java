package hibernateManagers;

import hibernateEntities.User;

import java.util.ArrayList;

public class CharityLoginManager {

	public static ArrayList<User> getUsers(String name, String DBConfname) {
		ConnectionManagerV2 conn = new ConnectionManagerV2();
		conn.setDBConfname(DBConfname);
		ArrayList<User> user = (ArrayList<User>) conn
				.getTable("User where userName = '" + name + "'");
		return user;
	}

}