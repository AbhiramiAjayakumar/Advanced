package com.example.security.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResource {

	@GetMapping("/")
	public String greet() {
		return "working";
	}

	@GetMapping
	@RequestMapping("/admin")
	public String greetAdmin() {
		return "Admin@work";
	}

	@GetMapping
	@RequestMapping("/user")
	public String greetUser() {
		return "User@work";

	}

}
