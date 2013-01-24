package ca.ulaval.ift6002.lab1.repertoire.rest;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ca.ulaval.ift6002.lab1.repertoire.core.DirectoryLocator;
import ca.ulaval.ift6002.lab1.repertoire.core.model.Directory;
import ca.ulaval.ift6002.lab1.repertoire.core.model.User;
import ca.ulaval.ift6002.lab1.repertoire.core.model.UserNotFoundException;

import com.sun.jersey.api.NotFoundException;

/**
 * Ressource représentant les utilisateurs.
 * 
 * Répond aux URLs /users/*
 */
@Path("/users/")
@Produces("application/xml")
public class UsersResource {
	private static Logger logger = Logger.getLogger(UsersResource.class.getName());

	private Directory directory = DirectoryLocator.getInstance().getDirectory();

	@GET
	public User[] getUsers() {
		return directory.getUsers();
	}

	@GET
	@Path("{userid}")
	public User getUser(@PathParam("userid") String userid) {
		logger.info("getUser(" + userid + ")");

		try {
			User user = directory.findUserFromId(userid);
			logger.info("USER FOUND " + userid);
			return user;
		} catch (UserNotFoundException e) {
			logger.warning("USER NOT FOUND " + userid);
			throw new NotFoundException();
		}
	}
}