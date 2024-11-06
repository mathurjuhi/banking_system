package com.bank.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.banking.dto.UserDto;
import com.bank.banking.model.UserAccount;
import com.bank.banking.service.UserService;

@RestController
@RequestMapping("/banking")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	@RequestMapping("/add/user")
	public ResponseEntity<Object> createUser(@RequestBody UserDto userdto){

		UserAccount account = userService.createUser(userdto);
		return new ResponseEntity<>(account,HttpStatus.OK);
		
		
	}

}
