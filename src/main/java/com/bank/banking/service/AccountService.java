package com.bank.banking.service;

import java.util.List;

import com.bank.banking.model.UserAccount;

public interface AccountService {
	
	public List<UserAccount> getAllAccounts();
    public UserAccount getAccountByUserId(String userId);
    public UserAccount getAccountById(long id);

}
