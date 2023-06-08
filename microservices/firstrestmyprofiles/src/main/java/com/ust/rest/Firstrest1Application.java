package com.ust.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.resource.Product;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.resource.Product;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Firstrest1Application implements CommandLineRunner {
	
	@Autowired
	ProductRepository repo;

	public static void main(String[] args) {
		//contains beans
		//springApplication is built in application
		ConfigurableApplicationContext ctxt =
		SpringApplication.run(Firstrest1Application.class, args);
		for(String str:args) {
			System.out.println(str);
		}
	boolean found=	ctxt.containsBean("productRepository");//contains and is function returns boolean
		System.out.println(found);
		boolean found1=ctxt.containsBean("repo");
		System.out.println(found1);
	}
	//repo is not here it is false
	@Override public void run(String... args) throws Exception{
		System.out.println("fromCommandLineRunner");//executes as soon as application starts,we can use it for building database

	
	List<Product> products =repo.findAll();
	System.out.println(products.size());
	}

}

