package org.lanyonm.playground.web.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author lanyonm
 */
public class TodoCommand {

	@NotNull
	@Size(min = 0, max = 250)
	private String title;

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
	
	public String toString() {
		return new StringBuilder("command.Todo: title=\"").append(this.title)
				.append("\"").toString();
	}
}
