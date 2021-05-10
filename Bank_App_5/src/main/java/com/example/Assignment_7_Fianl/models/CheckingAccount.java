package com.example.Assignment_7_Fianl.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Entity
public class CheckingAccount extends BankAccount {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	//@Column(name = "user_id")
//	private long id;
	
	private static double interest_rate = 0.0001;
	
	
	public static CheckingAccount readFromString(String accountData) throws ParseException {
		String[] data = accountData.split(",");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		int accNumb = Integer.parseInt(data[0]);
		double balance = Double.parseDouble(data[1]);
		double interestRate = Double.parseDouble(data[2]);
		Date openDate = formatter.parse(data[3]);

		return new CheckingAccount(accNumb, balance, interestRate, openDate);
	}
	
	public CheckingAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}
	
	public CheckingAccount(int accNumb, double balance, double interestRate, Date openDate) {
		super(accNumb, balance, interestRate, openDate);
	}
	
	public CheckingAccount() {
		super(0, interest_rate);
	}
	
	public CheckingAccount(double balance) {
		super(balance, interest_rate);
	}
	
}