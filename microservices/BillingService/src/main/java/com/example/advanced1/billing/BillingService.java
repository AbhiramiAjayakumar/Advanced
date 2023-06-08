package com.example.advanced1.billing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/billingservice")
public class BillingService {
	
		@Value("name") // value coming from properties file or yaml file
		String strMessage;

		@GetMapping
		public String welcomebilling() {
			return "Programming Billingservices" + strMessage;
		}

}
