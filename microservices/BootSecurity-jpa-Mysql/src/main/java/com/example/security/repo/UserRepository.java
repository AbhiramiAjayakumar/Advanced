package com.example.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{
	
	Optional<User>findByUserName(String name);

}
