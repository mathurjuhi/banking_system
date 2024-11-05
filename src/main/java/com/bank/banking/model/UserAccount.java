package com.bank.banking.model;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "User_Account", schema="online_schema")
public class UserAccount{
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	@NotNull
	private long userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_name")
	@NotNull
	private String userName;
	
	@Column(name = "pass")
	private String password;
	
	@Column(name = "addres")
	private String address;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private long mobile;
	
	public UserAccount() {
		
	}

	public UserAccount(@NotNull long userId, String firstName, String lastName, @NotNull String userName,
			String password, String address, Date dob, String email, long mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", address=" + address + ", dob=" + dob + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
	
	

}
