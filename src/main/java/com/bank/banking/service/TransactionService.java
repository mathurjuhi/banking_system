package com.bank.banking.service;

import com.bank.banking.model.TransactionDetail;

public interface TransactionService {

	TransactionDetail deposit(Long id, double amount);

	TransactionDetail withdraw(Long id, double amount);

}
