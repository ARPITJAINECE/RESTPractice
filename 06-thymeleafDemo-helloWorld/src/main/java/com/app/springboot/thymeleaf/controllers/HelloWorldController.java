package com.app.springboot.thymeleaf.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// add a controller method to show an initial HTML form
//	@RequestMapping("/showForm")
//	public String showForm() {
//		return "helloworld-form";
//	}
	// we would like to change the above method for only GET HTTP method
	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// then add a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}

	// need a controller method to read data and also add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request params from the HTML form
		String theName = request.getParameter("studentName");

		// convert that data to the upperCase
		theName = theName.toUpperCase();

		// create the message
		String result = "yoooooo!!!!!  " + theName;

		// add that msg. to the model
		model.addAttribute("message", result);

		return "helloworld";
	}// we will be using the @RequestParam so that it will read param from request
		// and will also automatically bind it to the variable and the we can use that
		// variable further

	@PostMapping("/processFormVersionThree")
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {

		// convert the data to the capital
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey My Friend !!!!!   V3::::   " + theName;

		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

}
