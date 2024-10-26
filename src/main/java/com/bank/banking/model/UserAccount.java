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
@Table(name = "User_Account")
public class UserAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public UserAccount(long accid, String fn, String ln, String userid, String pas, String add, String mail, String mob, double bal) {
		this.accountId = accid;
		this.firstName = fn;
		this.lastName = ln;
		this.userId = userid;
		this.pass = pas;
		this.addres = add;
		this.email = mail;
		this.mobile = mob;
		this.balance = bal;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "account_id")
	private long accountId;

	@Column(name = "first_name")
    private String firstName;

	@Column(name = "last_name")
    private String lastName;
	
    @NotNull
    private double balance;
    
    private String email;
	
    @Column(name = "", unique=true)
    @Size(min=3, max = 20)
    private String userId;

    @NotNull
    private String pass;

    private String addres;

    private String mobile;

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

}
