package ca.ulaval.ift6002.lab1.repertoire.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "group")
@XmlAccessorType(XmlAccessType.FIELD)
public class Group {
	private String id;
	private String description;

	protected Group() {
	}

	public Group(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}