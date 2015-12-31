package org.lanyonm.playground.domain;

import java.io.Serializable;

/**
 * @author lanyonm
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String firstName;
	private String lastName;
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return new StringBuilder("domain.User: firstName=\"").append(this.getFirstName())
				.append("\", lastName=\"").append(this.getLastName())
				.append("\", email=\"").append(this.getEmail()).append("\"").toString();
	}
}
