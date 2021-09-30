package com.sportyshoes.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sportyshoes.app.model.User;

import com.sportyshoes.app.repository.UserRepository;




@RestController
@RequestMapping("users")

public class UserController {
	@Autowired
	UserRepository userrepository;
	
	// update existing product
			@PutMapping("updatepassword/{uid}")
			public User updateUser(@RequestBody User password)
			{
				return userrepository.save(password);
			}
	//User Details
		@GetMapping("user")
		public List<User> getAllUser()
		{
			List<User> user=(List<User>) userrepository.findAll(); 
			return user;
		}
		@PostMapping("adduser")
		public User addUser(@RequestBody User user)
		{
			return userrepository.save(user);
		}
}
