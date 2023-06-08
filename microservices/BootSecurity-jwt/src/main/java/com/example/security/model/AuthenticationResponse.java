package com.example.security.model;

public class AuthenticationResponse {
	private final String jwt;
	 
	 public AuthenticationResponse(String jwt) {
		// TODO Auto-generated constructor stub
		 this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	 
	 

}
