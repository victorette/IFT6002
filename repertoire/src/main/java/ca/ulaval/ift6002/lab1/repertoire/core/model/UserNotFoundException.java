package ca.ulaval.ift6002.lab1.repertoire.core.model;

/**
 * Erreur indiquant que l'utilisateur n'existe pas.
 */
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}