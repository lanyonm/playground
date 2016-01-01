package org.lanyonm.playground.service;

import java.util.List;

import org.lanyonm.playground.domain.Todo;

/**
 * @author lanyonm
 */
public interface TodoService {

	/**
	 * @return a list of all the {@link Todo}s
	 */
	public List<Todo> getAllTodos();

	/**
	 * @param id
	 * @return the corresponding {@link Todo}
	 */
	public Todo getTodo(int id);

	/**
	 * @param todo
	 * @return whether the {@link Todo} was successfully saved
	 */
	public boolean saveTodo(Todo todo);

	/**
	 * @param todo
	 * @return whether the {@link Todo} was successfully deleted
	 */
	public boolean deleteTodo(Todo todo);
}
