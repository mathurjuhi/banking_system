package com.bank.banking.controller;

import com.bank.banking.dto.AccountDto;
import com.bank.banking.dto.TransferDto;
import com.bank.banking.model.AccountDetail;
import com.bank.banking.model.TransactionDetail;
import com.bank.banking.repository.TransactionRepository;
import com.bank.banking.service.TransactionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/banking")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    private TransactionRepository transRepo;

    // API to get all transactions for a specific account
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionDetail>> getTransactionById(@PathVariable Long accountId) {
        List<TransactionDetail> transactions = (List<TransactionDetail>) transRepo.getTransactionDetailById(accountId);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no transactions found
        }
        else {
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }}
    
    @PostMapping("/transaction/deposit/{accountId}")
    public  ResponseEntity<TransactionDetail> deposit(@PathVariable Long accountId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        TransactionDetail transaction= transactionService.deposit(accountId, amount);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

    @PostMapping("/transaction/withdraw/{accountId}")
    public ResponseEntity<TransactionDetail> withdraw(@PathVariable Long accountId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        TransactionDetail transaction=  transactionService.withdraw(accountId, amount);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }
    
    @PostMapping("/transfer")
    public ResponseEntity<String> transferAmount(@Valid @RequestBody TransferDto transferDto){
    	 String transaction =  transactionService.transferAmount(transferDto);
    	return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}
