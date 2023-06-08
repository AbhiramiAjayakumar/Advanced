package com.ust.rest.resource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="Product_User")
public class User {
  @Id
  @GeneratedValue
	private long userId;
  private String dateTime;
	public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public String getDateTime() {
	return dateTime;
}
public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
}
	
	
}
