package org.lanyonm.playground.web.controller;

import javax.servlet.http.HttpSession;

import org.lanyonm.playground.persistence.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private UserMapper userMapper;

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void index(Model model) {
		log.debug("In the HomeController::index");
		model.addAttribute("example", "Hello World!");
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public void users(Model model) {
		model.addAttribute("users", userMapper.getAllUsers());
	}
}
