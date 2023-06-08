package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.repository.UserRepository;
import com.ust.rest.resource.Product;
import com.ust.rest.resource.User;
@Service
public class ProductService {

	@Autowired//to product service it is going to inject
	ProductRepository productRepository;
	
	
	@Autowired
	UserRepository userRepository;
  @Transactional(propagation =Propagation.REQUIRED)
	public Product add(Product product) {
	
			
		Product productT= productRepository.save(product);
		 User user =new User();
		 user.setUserId(5L);
		 user.setDateTime(System.currentTimeMillis()+"76");
		 User userT = userRepository.save(user);
		 return productT;
	}
//		 System.out.println(userT);
//		 if(userT !=null && productT !=null)
//		 return true;
//		 else
//			 throw new RuntimeException("record not inserted...");
//	}
	
	public boolean validate(Product product) {
		if(product.getName().equals("camera")) {
			return true;
		}else {
			return false;
		}
	}
	public Product getProduct(long productId) {
		Optional<Product> optional=productRepository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	public  List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	  public Product updateProduct(Product product) { return
	  productRepository.save(product); }
	 
	  public void deleteProduct(long productId)
	  { productRepository.deleteById(productId); }
	 
}
