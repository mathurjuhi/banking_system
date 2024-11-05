package com.bank.banking.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Account_Detail"
, schema="online_schema")
public class AccountDetail {
	
	public AccountDetail() {}
	@Id
	@GeneratedValue
	@Column(name = "account_id")
	private long accountId;

	@Column(name = "user_id")
    private long userId;

	@Column(name = "acc_num")
    private long accNum;
	
    @Column (name ="balance")
    @NotNull
    private double balance;
    
    @Column(name = "acc_type")
    private String accType;
	
    @Column(name = "is_active")
    private boolean isActive;
    
    @Column(name = "created_date")
    private Date createdDate;

    
    
    
	public AccountDetail(long accountId, long userId, long accNum, @NotNull double balance, String accType,
			boolean isActive, Date createdDate) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accNum = accNum;
		this.balance = balance;
		this.accType = accType;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "AccountDetail [accountId=" + accountId + ", userId=" + userId + ", accNum=" + accNum + ", balance="
				+ balance + ", accType=" + accType + ", isActive=" + isActive + ", createdDate=" + createdDate + "]";
	}

}
