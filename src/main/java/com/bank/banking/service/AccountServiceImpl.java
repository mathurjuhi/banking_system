package com.bank.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banking.exception.UserNotFoundException;
import com.bank.banking.model.UserAccount;
import com.bank.banking.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public List<UserAccount> getAllAccounts() {
		List<UserAccount> userAccs = accountRepo.findAll();
		return userAccs;
	}

	@Override
	public UserAccount getAccountByUserId(String userId) {
		Optional<UserAccount> userAcc = Optional.ofNullable(accountRepo.findByUserId(userId));
		if(userAcc.isPresent()) {
			return userAcc.get();
		} else {
			throw new UserNotFoundException("Account with userId : "+userId+" Not Found");
	    }
	}

	@Override
	public UserAccount getAccountById(long id) {
		Optional<UserAccount> userAcc = accountRepo.findById(id);
		if(userAcc.isPresent()) {
	           return userAcc.get();
	       } else {
	           throw new UserNotFoundException("Account with Id : "+id+" Not Found");
	       }
	}

}
