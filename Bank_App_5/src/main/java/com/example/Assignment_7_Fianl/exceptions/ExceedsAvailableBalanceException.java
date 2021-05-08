package com.example.Assignment_7_Fianl.exceptions;

public class ExceedsAvailableBalanceException extends Exception {
	
	ExceedsAvailableBalanceException(String ERROR){
		super(ERROR);
	}
}
