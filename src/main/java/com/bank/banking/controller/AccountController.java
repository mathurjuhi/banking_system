package com.bank.banking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.banking.model.UserAccount;

@RestController
@RequestMapping("/banking")
public class AccountController {
	
	@GetMapping
	@RequestMapping("/test")
	public ResponseEntity<UserAccount> test() {
		UserAccount user = new UserAccount(20006 , "Richa","Ranjan", "richaR2", "csf12cdzxa", "HAL Bangalore","richaranjan@yahoo.com", "8877664411", 8022000.00);
		return ResponseEntity.ok(user);
	}

}
