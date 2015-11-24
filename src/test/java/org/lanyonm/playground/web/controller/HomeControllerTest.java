package org.lanyonm.playground.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lanyonm.playground.config.DataConfig;
import org.lanyonm.playground.config.ViewResolver;
import org.lanyonm.playground.config.WebConfig;
import org.lanyonm.playground.service.ExceptionServiceImpl;
import org.lanyonm.playground.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader=AnnotationConfigWebContextLoader.class, classes={DataConfig.class, ExceptionServiceImpl.class, UserServiceImpl.class, ViewResolver.class, WebConfig.class})
public class HomeControllerTest {

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
		this.mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(model().attribute("example", "Hello World!"))
				.andDo(document("index"));
	}

	@Test
	public void testUsers() throws Exception {
		this.mockMvc.perform(get("/users")).andExpect(status().isOk())
				.andExpect(model().attributeExists("users"))
				.andDo(document("users"));
	}

	@Test
	public void testExceptions() throws Exception {
		this.mockMvc.perform(get("/exceptions")).andExpect(status().isOk())
				.andExpect(model().attribute("exceptionsState", false));
	}

	@Test
	public void testToggleExceptions() throws Exception {
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("exceptionsToggle", false);
		this.mockMvc.perform(post("/exceptions").session(session)).andExpect(status().isOk())
				.andExpect(model().attribute("exceptionsState", true));
		this.mockMvc.perform(post("/exceptions").session(session)).andExpect(status().isOk())
				.andExpect(model().attribute("exceptionsState", false));
		this.mockMvc.perform(post("/exceptions").session(session)).andExpect(status().isOk())
				.andExpect(model().attribute("exceptionsState", true));
		this.mockMvc.perform(post("/exceptions").session(session)).andExpect(status().isOk())
				.andExpect(model().attribute("exceptionsState", false));
	}
}
