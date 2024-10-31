package com.bank.banking.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TransactionDetail", schema="online_schema")
public class TransactionDetail {
	
	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	private Long transactionId;

	@ManyToOne
	@Column(name = "account_id")
	private UserAccount user;
	
	@Column(name = "date_of_transaction")
    private Date transactionDate;
	
	@Column(name = "type")
	private String accType;
	
	@NotNull
	private Double amount;
	
	private Double credit;
	
	private Double debit;
	
	

	public TransactionDetail() {
	}
	
	public TransactionDetail(Long transactionId, UserAccount user, Date transactionDate, String accType,
			@NotNull Double amount, Double credit, Double debit) {
		this.transactionId = transactionId;
		this.user = user;
		this.transactionDate = transactionDate;
		this.accType = accType;
		this.amount = amount;
		this.credit = credit;
		this.debit = debit;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Double getDebit() {
		return debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
	}
	
	
}
