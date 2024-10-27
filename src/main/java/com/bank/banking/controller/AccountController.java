package com.bank.banking.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.banking.dto.AccountDto;
import com.bank.banking.model.UserAccount;
import com.bank.banking.service.AccountService;

@RestController
@RequestMapping("/banking")
public class AccountController {
	
	@Autowired

	private AccountService accountService;
	
	@GetMapping("/accounts")
	public ResponseEntity<List<UserAccount>> getAllAccounts() {
		List<UserAccount> userAccs = accountService.getAllAccounts();
		return ResponseEntity.ok(userAccs);
	}
	
	@GetMapping("/account/accountId/{accId}")
	public ResponseEntity<UserAccount> getAccountById(@PathVariable Long accId) {
		UserAccount userAccs = accountService.getAccountById(accId);
		return ResponseEntity.ok(userAccs);
	}
	
	@GetMapping("/account/accountUserId/{userId}")
	public ResponseEntity<UserAccount> getAccountByUserId(@PathVariable String userId) {
		UserAccount userAccs = accountService.getAccountByUserId(userId);
		return ResponseEntity.ok(userAccs);
	}
	
	
	@PostMapping
	@RequestMapping("/add/account")
	public ResponseEntity<Object> createNewAccount(@RequestBody AccountDto accountDto){
		
		UserAccount account = accountService.createAccount(accountDto);
		return new ResponseEntity<>(account,HttpStatus.OK);
	}
	
	@PostMapping("/account/deposit/{accountId}")
    public  ResponseEntity<UserAccount> deposit(@PathVariable Long accountId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        UserAccount account= accountService.deposit(accountId, amount);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @PostMapping("/account/withdraw/{accountId}")
    public ResponseEntity<UserAccount> withdraw(@PathVariable Long accountId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        UserAccount account=  accountService.withdraw(accountId, amount);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }


}
