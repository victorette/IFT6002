package ca.ulaval.ift6002.lab1.repertoire.core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represente un utilisateur et ses informations.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	private String id;
	private String firstName;
	private String lastName;

	@XmlElementWrapper()
	@XmlElements({ @XmlElement(name = "groupes") })
	private List<Group> groups = Collections.synchronizedList(new ArrayList<Group>());

	protected User() {
	}

	public User(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void addIntoGroup(Group group) {
		groups.add(group);
	}

	public Group[] getGroups() {
		return groups.toArray(new Group[groups.size()]);
	}

	public boolean matchUserId(String userId) {
		return id.compareToIgnoreCase(userId) == 0;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}