package com.example.Assignment_7_Fianl.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CDOffering")

public class CDOffering {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "user_id")
	private long id;

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