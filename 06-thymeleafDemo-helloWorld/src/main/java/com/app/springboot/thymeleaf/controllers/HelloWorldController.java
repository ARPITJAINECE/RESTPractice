package com.app.springboot.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// add a controller method to show an initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// then add a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}

}
