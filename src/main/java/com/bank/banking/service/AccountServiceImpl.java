package com.bank.banking.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banking.dto.AccountDto;
import com.bank.banking.exception.InsufficientFundException;
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
		if (userAcc.isPresent()) {
			return userAcc.get();
		} else {
			throw new UserNotFoundException("Account with userId : " + userId + " Not Found");
		}
	}

	@Override
	public UserAccount getAccountById(long id) {
		Optional<UserAccount> userAcc = accountRepo.findById(id);
		if (userAcc.isPresent()) {
			return userAcc.get();
		} else {
			throw new UserNotFoundException("Account with Id : " + id + " Not Found");
		}
	}

	@Override
	public UserAccount createAccount(AccountDto account) {
		UserAccount userAccount = new UserAccount();
		userAccount.setAccountId(account.getAccountId());
		userAccount.setFirstName(account.getFirstName());
		userAccount.setLastName(account.getLastName());
		userAccount.setBalance(account.getBalance());
		userAccount.setUserId(account.getUserId());
		userAccount.setPass(account.getPass());
		userAccount.setAddres(account.getAddres());
		userAccount.setEmail(account.getEmail());
		userAccount.setMobile(account.getMobile());

		UserAccount account2 = accountRepo.save(userAccount);
		if (account2 != null)
			return account2;
		else
			throw new ConstraintViolationException("User with user id:" + account.getUserId() + "already exist.", null,
					account.getUserId());

	}

	@Override
	public UserAccount deposit(Long id, double amount) {
		UserAccount account = getAccountById(id);
		account.setBalance(account.getBalance() + amount);
		return accountRepo.save(account);
	}

	@Override
	public UserAccount withdraw(Long id, double amount) {
		UserAccount account = getAccountById(id);
		if (account.getBalance() < amount) {
			throw new InsufficientFundException("User has not sufficient balance to withdraw");
		}
		account.setBalance(account.getBalance() - amount);
		return accountRepo.save(account);
	}

	@Override
	public void update(Long accountId, String fn, String ln, String pass, String add, String email, String mob) {
		UserAccount account = getAccountById(accountId);
		if (Objects.nonNull(account.getAccountId())) {
			accountRepo.update(fn, ln, pass, add, email, mob, accountId);
		}
		else {
			throw new UserNotFoundException("User not found to update");
		}
	}
}
