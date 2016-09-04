package com.sunRays.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld(@RequestParam(value = "name") String name) {
		String message = "Hello "+name;
		return new ModelAndView("welcome", "message", message);
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list() {
		List<String> users = new ArrayList<String>();
		users.add("sun");
		users.add("Bhawna");
		return new ModelAndView("users", "users", users);
	}
	
}
