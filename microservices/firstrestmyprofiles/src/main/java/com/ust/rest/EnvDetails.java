package com.ust.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvDetails {
	@Value("${app.server.name}")
	private String appServerName;
	@Value("${server.port}")
	private String portNumber;
	@Value("${spring-datasource}")
	private String username;
	@Override
	public String toString() {
		return "EnvDetails [appServerName=" + appServerName + ", portNumber=" + portNumber + "]";
	}
	public String getAppServerName() {
		return appServerName;
	}
	public void setAppServerName(String appServerName) {
		this.appServerName = appServerName;
	}
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	
	

}
