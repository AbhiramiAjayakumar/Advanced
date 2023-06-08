package com.example.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.model.MyUserDetails;
import com.example.security.model.User;
import com.example.security.repo.UserRepository;


@Service
	public class MyUserDetailService implements UserDetailsService {

		@Autowired
		UserRepository repo;
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
		Optional<User> user= repo.findByUserName(username);
		user.orElseThrow(() -> ( new UsernameNotFoundException("Not Found: " + username ) ));
		
		return user.map(MyUserDetails::new).get();
		}
	}


