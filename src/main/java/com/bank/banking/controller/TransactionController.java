package com.bank.banking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.banking.model.Transaction;
import com.bank.banking.repository.TransactionRepository;
import com.bank.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/banking")
public class TransactionController {

    @Autowired
    private TransactionService TransSer;
    private TransactionRepository transRepo;

    // API to get all transactions for a specific account
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionById(@PathVariable Long accountId) {
        List<Transaction> transactions = (List<Transaction>) transRepo.getTransactionById(accountId);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no transactions found
        }
        else {
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }}
}
