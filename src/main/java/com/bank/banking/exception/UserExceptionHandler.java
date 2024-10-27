package com.bank.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public ResponseEntity<GlobalErrorType> userNotFoundExceptionHandler(UserNotFoundException userNotFoundExp){
		return new ResponseEntity<GlobalErrorType>(
				new GlobalErrorType(userNotFoundExp.getMessage(), "ACCOUNT_NOT_FOUND"), HttpStatus.NOT_FOUND);
	}
}
