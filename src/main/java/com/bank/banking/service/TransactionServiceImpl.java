package com.bank.banking.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banking.exception.InsufficientFundException;
import com.bank.banking.exception.UserNotFoundException;
import com.bank.banking.model.AccountDetail;
import com.bank.banking.model.TransactionDetail;
import com.bank.banking.repository.AccountRepository;
import com.bank.banking.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public TransactionDetail deposit(Long id, double amount) {
		AccountDetail account = accountRepository.findByAccountId(id);

		if (account == null)
			throw new UserNotFoundException("Account with Id : " + id + " Not Found");
		Double balance = account.getBalance() + amount;
		//update balance in account
		account.setBalance(balance);
		accountRepository.save(account);

		//add new row in transaction
		TransactionDetail transaction = new TransactionDetail();
		transaction.setAccountDetail(account);
		transaction.setAmount(amount);
		transaction.setBalance(balance);
		transaction.setTransactionType("Deposit");
		transaction.setTransactionDate(new Date());
		transactionRepository.save(transaction);

		return transaction;
	}

	@Override
	public TransactionDetail withdraw(Long id, double amount) {
		AccountDetail account = accountRepository.findByAccountId(id);

		if (account == null)
			throw new UserNotFoundException("Account with Id : " + id + " Not Found");
		
		if (account.getBalance() < amount)  
			throw new InsufficientFundException("User has not sufficient balance to withdraw"); 
		
		Double balance = account.getBalance() - amount;
		//update balance in account
		account.setBalance(balance);
		accountRepository.save(account);

		//add new row in transaction
		TransactionDetail transaction = new TransactionDetail();
		transaction.setAccountDetail(account);
		transaction.setAmount(amount);
		transaction.setBalance(balance);
		transaction.setTransactionType("Withdraw");
		transaction.setTransactionDate(new Date());
		transactionRepository.save(transaction);

		return transaction;
	}
}
