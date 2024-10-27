package com.bank.banking.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountDto {
	
	private long accountId;

    private String firstName;

    private String lastName;
	
    private double balance;
    
    private String email;
	
    private String userId;
    
    private String pass;

    private String addres;

    private String mobile;


    public AccountDto(long accountId, String firstName, String lastName, double balance, String email, String userId,
			String pass, String addres, String mobile) {
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.email = email;
		this.userId = userId;
		this.pass = pass;
		this.addres = addres;
		this.mobile = mobile;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "AccountDto [accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", balance=" + balance + ", email=" + email + ", userId=" + userId + ", pass=" + pass + ", addres="
				+ addres + ", mobile=" + mobile + "]";
	}


}
