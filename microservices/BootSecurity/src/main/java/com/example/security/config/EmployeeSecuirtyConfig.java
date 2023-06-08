package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class EmployeeSecuirtyConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception// AuthenticationMangeer BUilder for
																				// Authentication
	{
		auth.inMemoryAuthentication().withUser("bond").password("james").roles("USER").and().withUser("poo")
				.password("bear").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception// HTtpSecurity for AUthorization
	{
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasAnyRole("USER")
				.antMatchers("/").permitAll().and().formLogin();
	}

	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
