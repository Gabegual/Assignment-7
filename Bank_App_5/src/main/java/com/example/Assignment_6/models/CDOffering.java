package com.example.Assignment_6.models;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CDOffering {
	
	@NotNull
	@Min(value = 1, message = " term must be >")
	private int term;
	public double interestRate;
	
	public CDOffering() {
		
	}
	
	static CDOffering readFromString(String CDOfferingDataString) {
		String[] data = CDOfferingDataString.split(",");
		int term = Integer.parseInt(data[0]);
		double interestRate = Double.parseDouble(data[1]);
		
		return new CDOffering(term, interestRate);
	}
	
	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
		
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int years) {
		this.term = years;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
}