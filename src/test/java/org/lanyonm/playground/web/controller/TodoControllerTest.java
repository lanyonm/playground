package org.lanyonm.playground.web.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lanyonm.playground.config.DataConfig;
import org.lanyonm.playground.config.ViewResolver;
import org.lanyonm.playground.config.WebConfig;
import org.lanyonm.playground.domain.Todo;
import org.lanyonm.playground.service.ExceptionServiceImpl;
import org.lanyonm.playground.service.TodoServiceImpl;
import org.lanyonm.playground.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author lanyonm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader=AnnotationConfigWebContextLoader.class, classes={DataConfig.class, ExceptionServiceImpl.class, TodoServiceImpl.class, UserServiceImpl.class, ViewResolver.class, WebConfig.class})
public class TodoControllerTest {

	@Rule
	public final RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets");

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
				.apply(documentationConfiguration(this.restDocumentation))
				.build();
	}

	@Test
	public void testIndex() throws Exception {
		this.mockMvc.perform(get("/todo/")).andExpect(status().isOk())
				.andExpect(view().name("todo/index"))
				.andExpect(model().attributeExists("todoList"))
				.andDo(document("todo"));
	}

	@Test
	public void testTodoAddEditShow() throws Exception {
		this.mockMvc.perform(get("/todo/{id}/edit", Integer.MAX_VALUE))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/todo/"));
		this.mockMvc.perform(get("/todo/{id}/edit", 0))
				.andExpect(status().isOk())
				.andExpect(view().name("todo/addEdit"))
				.andExpect(model().attribute("todo", new Todo()));
		this.mockMvc.perform(get("/todo/{id}/edit", 1))
				.andExpect(status().isOk())
				.andExpect(view().name("todo/addEdit"))
				.andExpect(model().attributeExists("todo"));
	}

	@Test
	public void testTodoEdit() throws Exception {
		// TODO add coverage for nefarious edit
		this.mockMvc.perform(post("/todo/{id}/edit", 1).param("title", "furst tudo"))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/todo/"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testTodoAddDelete() throws Exception {
		this.mockMvc.perform(post("/todo/{id}/edit", 0).param("title", "second todo"))
				.andExpect(redirectedUrl("/todo/"));
		MvcResult result = this.mockMvc.perform(get("/todo/"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("todoList"))
				.andReturn();
		List<Todo> todoList = (List<Todo>) result.getModelAndView().getModel().get("todoList");
		assertEquals("there should be two todos", todoList.size(), 2);
		long todoId = todoList.get(todoList.size() - 1).getId();
		this.mockMvc.perform(get("/todo/{id}/delete", todoId))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/todo/"));
		result = this.mockMvc.perform(get("/todo/"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("todoList"))
				.andReturn();
		todoList = (List<Todo>) result.getModelAndView().getModel().get("todoList");
		assertEquals("there should be one todo", todoList.size(), 1);
	}
}
