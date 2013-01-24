package ca.ulaval.ift6002.lab1.repertoire.core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Représente un répertoire qui a des utilisateurs et des groupes.
 */
public class Directory {

	private List<User> users = Collections.synchronizedList(new ArrayList<User>());

	public User[] getUsers() {
		return users.toArray(new User[users.size()]);
	}

	public void addUser(User user) {
		users.add(user);
	}

	public synchronized User findUserFromId(String id) throws UserNotFoundException {
		for (User user : users) {
			if (user.matchUserId(id)) {
				return user;
			}
		}

		throw new UserNotFoundException(String.format("User with id '%s' doesn't exist.", id));
	}

}