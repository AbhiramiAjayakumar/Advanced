package com.example.advanced.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/service")
public class HelloService {
	@Value("name") // value coming from properties file or yaml file
	String strMessage;

	@Autowired
	Environment environment;// is a reference to properties file
   @GetMapping
	public String Welcome() {
		String port = environment.getProperty("server.port");
		return "Programming Microservices@" + port;
	}

	/*
	 * @GetMapping public String welcome() { return "Programming Microservices" +
	 * strMessage; }
	 */

	@GetMapping("/status")
	public String status() {
		return "Up and running-->>";
	}

}
