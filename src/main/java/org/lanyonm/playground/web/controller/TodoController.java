package org.lanyonm.playground.web.controller;

import java.util.Date;

import org.lanyonm.playground.domain.Todo;
import org.lanyonm.playground.service.TodoService;
import org.lanyonm.playground.web.command.TodoCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lanyonm
 */
@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;

	private static final Logger log = LoggerFactory.getLogger(TodoController.class);

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/todo/", method = RequestMethod.GET)
	public String index(Model model) {
		log.debug("for logging's sake");
		model.addAttribute("todoList", todoService.getAllTodos());
		return "todo/index";
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/todo/{id}/edit", method = RequestMethod.GET)
	public String todoAddEditShow(@PathVariable("id") final int id, Model model) {
		Todo todo = todoService.getTodo(id);
		if (todo == null && id > 0) {
			// TODO message something
			return "redirect:/todo/";
		} else if (id == 0) {
			todo = new Todo();
		}
		model.addAttribute("todo", todo);
		return "todo/addEdit";
	}

	/**
	 * @param id
	 * @param model
	 * @param todoCommand
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/todo/{id}/edit", method = RequestMethod.POST)
	public String todoAddEditSave(@PathVariable("id") final int id, Model model, @ModelAttribute("todo") TodoCommand todoCommand, BindingResult bindingResult) {
		Todo todo = new Todo();
		if (id == 0) {
			todo.setTitle(todoCommand.getTitle());
			todo.setDateCreated(new Date());
			todoService.saveTodo(todo);
			// TODO verify the result of saveTodo()
		} else {
			todo = todoService.getTodo(id);
			if (todo != null) {
				todo.setTitle(todoCommand.getTitle());
				todo.setDateModified(new Date());
				todoService.saveTodo(todo);
				// TODO verify the result of saveTodo()
			} else {
				// TODO message something
			}
		}
		return "redirect:/todo/";
	}

	@RequestMapping(value = "/todo/{id}/delete", method = RequestMethod.GET)
	public String todoDelete(@PathVariable("id") final int id, Model model) {
		Todo todo = todoService.getTodo(id);
		if (todoService.deleteTodo(todo)) {
			// TODO send a success message!
		} else {
			// TODO send a failture message  >:|
		}
		return "redirect:/todo/";
	}
}
