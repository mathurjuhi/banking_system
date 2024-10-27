package com.bank.banking.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DuplicateKeyException;
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
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<GlobalErrorType> duplicateUserExceptionHandler(ConstraintViolationException duplicateUsrEx){
		
		return new ResponseEntity<GlobalErrorType>
		(new GlobalErrorType("User already exist", "DUPLICATE_DATA"),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InsufficientFundException.class)
	@ResponseBody
	public ResponseEntity<GlobalErrorType> insufficientFundExceptionHandler(InsufficientFundException insuffcFund){
		
		return new ResponseEntity<GlobalErrorType>
		(new GlobalErrorType(insuffcFund.getMessage(), "INSUFFICIENT_FUND"),HttpStatus.BAD_REQUEST);
	}
}


