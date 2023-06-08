package com.ust.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.resource.Product;
import com.ust.rest.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product/api.1.0")//controller will use services to get product from repository
//@RequestMapping("/cust")
@Api(value="Product service API 2.0",description="Rest endpoints for product API")
public class ProductResource {
	 @Autowired
	 ProductService service;
		
		
		  @GetMapping
		  
	  @RequestMapping("/retrieve/{productId}")
		 @ApiOperation(value="Returns the product entity")
		 
		  public Product  fetchProduct(@PathVariable long productId) { return
		  service.getProduct(productId);
		  
		  }
		  
			
		  
		  
			  @GetMapping
			  
			  @RequestMapping("/retrieve/all")
			  @ApiOperation(value="Returns the product entity")
			  public List<Product>fetchProducts(){//api methods
				  return service.getProducts();
				  }

			 	 
	
	@PostMapping
	@RequestMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="Returns the product entity")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		Exception exception=null;
		Product tempProduct=null;
		try {
			tempProduct=service.add(product);
		}
		catch(Exception e) {
			exception=e;
		}
	//boolean result=	service.add(product);
	if(tempProduct!=null) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tempProduct);
	}else {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
	}
	}
	
	
	  @PutMapping
	  
	  @RequestMapping(value="/update",consumes=MediaType.APPLICATION_JSON_VALUE,
	  produces=MediaType.APPLICATION_JSON_VALUE) 
	  @ApiOperation(value="Returns the product entity")
	  public Product  updateProduct(@RequestBody Product product) {
		  return  service.updateProduct(product); }
	 
	 
	  
	  @GetMapping
	  public String test() {
		  return "test() called.....";//for product client project
	  }
	 
	  @DeleteMapping
	  
	  @RequestMapping(value="delete/{productId}")
	  @ApiOperation(value="Returns the product entity")
	  public void  deleteProduct(@PathVariable long productId) {
	  service.deleteProduct(productId); }
	
}
