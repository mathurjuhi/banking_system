package com.bank.banking.service;

import com.bank.banking.dto.UserDto;
import com.bank.banking.model.UserAccount;

public interface UserService {
	
	public UserAccount createUser(UserDto user);

}
