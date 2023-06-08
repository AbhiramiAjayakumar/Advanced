package com.ust.rest.resource;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public   class Product {
	@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productid")
private long productId;//order first productrepo then service then resource
 private String name;
 private String description;
 private BigDecimal price;
 private int qty;
 
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public long getProductId() {
	return productId;
}
public void setProductId(long productId) {
	this.productId = productId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
	this.description = description;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}

 
}
