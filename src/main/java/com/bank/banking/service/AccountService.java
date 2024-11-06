package com.bank.banking.service;

import java.util.List;
import java.util.Map;

import com.bank.banking.dto.AccountDto;
import com.bank.banking.dto.UserDto;
import com.bank.banking.model.AccountDetail;
import com.bank.banking.model.UserAccount;

public interface AccountService {

	public List<AccountDetail> getAllAccounts();

	public AccountDetail getAccountByUserId(String userId);

	public AccountDetail getAccountById(long id);

	public AccountDetail createAccount(AccountDto account) ;

	public void update(Long accountId, String fn, String ln, String pass, String add, String email, String mob);

}
