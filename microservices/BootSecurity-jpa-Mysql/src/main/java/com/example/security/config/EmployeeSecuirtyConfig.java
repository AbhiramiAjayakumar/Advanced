package com.example.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class EmployeeSecuirtyConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;

	@Autowired
	UserDetailsService userdetailsservice;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception// AuthenticationMangeer BUilder for
																				// Authentication
	{
		/*
		 * auth.inMemoryAuthentication().withUser("bond").password("james").roles("USER"
		 * ).and().withUser("poo") .password("bear").roles("ADMIN");
		 */
		auth.userDetailsService(userdetailsservice);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception// HttpSecurity for AUthorization
	{
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasRole("USER")
				.antMatchers("/").permitAll().and().formLogin();
	}

	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
