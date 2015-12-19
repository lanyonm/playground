package org.lanyonm.playground.web.controller;

import javax.servlet.http.HttpSession;

import org.lanyonm.playground.service.ExceptionService;
import org.lanyonm.playground.service.UserService;
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
	private ExceptionService exceptionService;
	@Autowired
	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void index(Model model) {
		log.debug("In the HomeController::index");
		model.addAttribute("example", "Hello World!");
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public void users(Model model) {
		model.addAttribute("users", userService.getAllUsers());
	}

	@RequestMapping(value = "/exceptions", method = RequestMethod.GET)
	public void exceptions(Model model, HttpSession session) {
		model.addAttribute("exceptionsState", isThrowingExceptions(session));
	}

	@RequestMapping(value = "/exceptions", method = RequestMethod.POST)
	public String toggleExceptions(Model model, HttpSession session) {
		model.addAttribute("exceptionsState", toggleExceptions(session));
		return "exceptions";
	}

	/**
	 * keep an <tt>exceptionsToggle</tt> in the user's session
	 *
	 * @param session
	 */
	private boolean toggleExceptions(HttpSession session) {
		if (!isThrowingExceptions(session)) {
			session.setAttribute("exceptionsToggle", true);
			exceptionService.startThrowingExceptions();
			return true;
		}
		session.setAttribute("exceptionsToggle", false);
		exceptionService.stopThrowingExceptions();
		return false;
	}

	/**
	 *
	 * @param session
	 * @return true if the user's session is currently throwing exceptions
	 */
	private boolean isThrowingExceptions(HttpSession session) {
		if (session.getAttribute("exceptionsToggle") == null) {
			log.debug("the exceptionToggle was null");
			session.setAttribute("exceptionsToggle", false);
		}
		return (Boolean) session.getAttribute("exceptionsToggle");
	}
}
