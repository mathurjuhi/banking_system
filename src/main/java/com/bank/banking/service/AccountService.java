package com.bank.banking.service;

import java.util.List;

import com.bank.banking.dto.AccountDto;
import com.bank.banking.model.UserAccount;

public interface AccountService {

	public List<UserAccount> getAllAccounts();

	public UserAccount getAccountByUserId(String userId);

	public UserAccount getAccountById(long id);

	public UserAccount createAccount(AccountDto account);

	public UserAccount deposit(Long id, double amount);

	public UserAccount withdraw(Long id, double amount);

}
