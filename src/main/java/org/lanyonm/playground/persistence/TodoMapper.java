package org.lanyonm.playground.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanyonm.playground.domain.Todo;

/**
 * @author lanyonm
 */
public interface TodoMapper {

	/**
	 * @return all rows from the 'todos' table
	 */
	@Select("SELECT id, title, dateCreated, dateModified FROM todos")
	public List<Todo> getAllTodos();

	/**
	 * @param id
	 * @return the corresponding {@link Todo}
	 */
	@Select("SELECT * FROM todos WHERE ID = #{id}")
	public Todo getTodo(int id);

	/**
	 * @param todo the {@link Todo} to add
	 * @return the number of new rows inserted
	 */
	@Insert("INSERT INTO todos (title, dateCreated) VALUES (#{title}, #{dateCreated})")
	public int insertTodo(Todo todo);

	/**
	 * @param todo the {@link Todo} to update
	 * @return the number of rows altered
	 */
	@Update("UPDATE todos SET title = #{title}, dateModified = #{dateModified} WHERE id = #{id}")
	public int updateTodo(Todo todo);

	/**
	 * @param todo
	 * @return the number of rows deleted
	 */
	@Delete("DELETE FROM todos WHERE id = #{id}")
	public int deleteTodo(Todo todo);
}
