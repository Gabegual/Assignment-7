package com.example.Assignment_6.models;

public class ExceedsAvailableBalanceException extends Exception {
	
	ExceedsAvailableBalanceException(String ERROR){
		super(ERROR);
	}
}
