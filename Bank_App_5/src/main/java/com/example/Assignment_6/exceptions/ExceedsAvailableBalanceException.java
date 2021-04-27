package com.example.Assignment_6.exceptions;

public class ExceedsAvailableBalanceException extends Exception {
	
	ExceedsAvailableBalanceException(String ERROR){
		super(ERROR);
	}
}
