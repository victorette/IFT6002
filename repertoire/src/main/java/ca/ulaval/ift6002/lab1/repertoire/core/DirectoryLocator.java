package ca.ulaval.ift6002.lab1.repertoire.core;

import ca.ulaval.ift6002.lab1.repertoire.core.model.Directory;
import ca.ulaval.ift6002.lab1.repertoire.core.model.User;

public class DirectoryLocator {

	private static DirectoryLocator instance;
	private Directory directory;

	public DirectoryLocator() {
		directory = new Directory();

		directory.addUser(new User("alice", "Alice", "Bertrand"));
		directory.addUser(new User("bob", "Bob", "Raymond"));
	}

	public static synchronized DirectoryLocator getInstance() {
		if (instance == null) {
			instance = new DirectoryLocator();
		}
		return instance;
	}

	public Directory getDirectory() {
		return directory;
	}
}