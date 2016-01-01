package org.lanyonm.playground.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lanyonm
 */
public class Todo implements Serializable {

	private static final long serialVersionUID = 8865480730387267259L;
	private long id;
	private String title;
	private Date dateCreated;
	private Date dateModified;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the dateModified
	 */
	public Date getDateModified() {
		return dateModified;
	}
	/**
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		return (obj instanceof Todo &&
				((Todo) obj).getId() == this.getId() &&
				(this.getTitle() == null ? ((Todo) obj).getTitle() == null : this.getTitle().equals(((Todo) obj).getTitle())) &&
				(this.getDateCreated() == null ? ((Todo) obj).getDateCreated() == null : this.getDateCreated().equals(((Todo) obj).getDateCreated())));
	}

	public String toString() {
		return new StringBuilder("domain.Todo: title=\"").append(this.title)
				.append("\", dateCreated=\"").append(this.dateCreated)
				.append("\"").toString();
	}
}
