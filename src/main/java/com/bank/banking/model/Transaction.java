package com.bank.banking.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Transaction")

public class Transaction {
    @Id
    private Long id;
    private Long accountId; // ID of the associated account
    private String type; // Transaction type: Deposit, Withdrawal
    private double amount; // Transaction amount
    private String timeframe; // Transaction timestamp

    // Constructors
    public Transaction() {}

    public Transaction(Long accountId, String type, double amount, String timeframe) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timeframe = timeframe;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timeframe;
    }

    public void setTimestamp(String timeframe) {
        this.timeframe = timeframe;
    }

}
