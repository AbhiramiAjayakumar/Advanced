package com.example.advanced1.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
public class HelloClientResources {
	@Autowired
	RestTemplate template;

	@GetMapping
	public String callServer() {

		String url = "http://localhost:8093/rest/service/status";// gateway String
		String output = template.getForObject(url, String.class);
		return output;
	}

	//@RequestMapping("/server1")
	@GetMapping("/server1")
	public String callServer1() {

		String url = "http://localhost:8093/rest/billingservice";// gateway
		String output = template.getForObject(url, String.class);
		return output;

	}

	// String url="http://localhost:8094/rest/service";// for direct execution
	// service
	// String output=template.getForObject(url, String.class);
}
