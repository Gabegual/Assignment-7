package com.example.Assignment_7_Fianl.models;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.StringTokenizer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Entity
public class SavingsAccount extends BankAccount {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	//@Column(name = "user_id")
//	private long id;
	
		private static double INTEREST_RATE = 0.01;
		SavingsAccount(double balance, double interestRate){
			super(balance, interestRate);    
	     }
		
		SavingsAccount(int accNumb, double balance, double interestRate, Date openDate){
			super(accNumb, balance, interestRate, openDate);    
	     }
		
		// 0.00001 is the default interest rate.
		SavingsAccount(double balance) {
			super(balance, INTEREST_RATE);
		}
		
		public SavingsAccount() {
			super(0, INTEREST_RATE);
		}
		
		public static SavingsAccount readFromString(String accountData) throws ParseException {
			String[] data = accountData.split(",");
			
			// Create a date formatter
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			int accNumb = Integer.parseInt(data[0]);
			double balance = Double.parseDouble(data[1]);
			double interestRate = Double.parseDouble(data[2]);
			Date openDate = formatter.parse(data[3]);
		    
		    return new SavingsAccount(accNumb, balance, interestRate, openDate);
		}
}