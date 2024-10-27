package com.bank.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.banking.model.UserAccount;
import com.bank.banking.service.AccountService;

@RestController
@RequestMapping("/banking")
public class AccountController {
	
	@Autowired
	private AccountService accountSer;
	
	@GetMapping("/accounts")
	public ResponseEntity<List<UserAccount>> getAllAccounts() {
		List<UserAccount> userAccs = accountSer.getAllAccounts();
		return ResponseEntity.ok(userAccs);
	}
	

	@GetMapping("/account/accountId/{accId}")
	public ResponseEntity<UserAccount> getAccountById(@PathVariable Long accId) {
		UserAccount userAccs = accountSer.getAccountById(accId);
		return ResponseEntity.ok(userAccs);
	}
	
	@GetMapping("/account/accountUserId/{userId}")
	public ResponseEntity<UserAccount> getAccountByUserId(@PathVariable String userId) {
		UserAccount userAccs = accountSer.getAccountByUserId(userId);
		return ResponseEntity.ok(userAccs);
	}
}
