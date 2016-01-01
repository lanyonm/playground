package org.lanyonm.playground.service;

import java.util.List;

import org.lanyonm.playground.domain.Todo;
import org.lanyonm.playground.persistence.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lanyonm
 */
@Service("todoService")
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoMapper todoMapper;

	/* (non-Javadoc)
	 * @see org.lanyonm.playground.service.TodoService#getAllTodos()
	 */
	@Override
	public List<Todo> getAllTodos() {
		return todoMapper.getAllTodos();
	}

	/* (non-Javadoc)
	 * @see org.lanyonm.playground.service.TodoService#getTodo(int)
	 */
	@Override
	public Todo getTodo(int id) {
		return todoMapper.getTodo(id);
	}

	/* (non-Javadoc)
	 * @see org.lanyonm.playground.service.TodoService#saveTodo(org.lanyonm.playground.domain.Todo)
	 */
	@Override
	public boolean saveTodo(Todo todo) {
		int ret = 0;
		if (todo.getId() > 0) {
			ret = todoMapper.updateTodo(todo);
		} else {
			ret = todoMapper.insertTodo(todo);
		}
		return ret == 1;
	}

	/* (non-Javadoc)
	 * @see org.lanyonm.playground.service.TodoService#deleteTodo(org.lanyonm.playground.domain.Todo)
	 */
	@Override
	public boolean deleteTodo(Todo todo) {
		return todoMapper.deleteTodo(todo) > 0;
	}

}
