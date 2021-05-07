package com.example.Assignment_6.models;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

//import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.sun.el.parser.ParseException;

@Entity
public class CDAccount extends BankAccount {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	//@Column(name = "user_id")
//	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="offering_id")
	CDOffering offerings;
	int term;

	public CDAccount() {
		super();
	}

	public void setTerm(int term) {
		this.term = term;

	}

	public CDAccount(CDOffering offering, double openingBalance) {
		super(openingBalance, offering.getInterestRate());
		this.offerings = offering;
		this.term = offering.getTerm();
	}
	/*
	 * @param accountNumber
	 * 
	 * @param balance
	 * 
	 * @param interestRate
	 * 
	 * @param term
	 */

	public CDAccount(Long accountNumber, Double balance, Double interestRate, Date openedOn, int term) {
		super(accountNumber, balance, interestRate, openedOn);
		this.term = term;
	}

	public static CDAccount readFromString(String accountData) throws ParseException {
		try {
			String[] temp = accountData.split(",");
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(temp[3]);
			CDAccount newAccount = new CDAccount(Long.valueOf(temp[0]), Double.valueOf(temp[1]),
					Double.valueOf(temp[2]), date, Integer.valueOf(temp[4]));
			return newAccount;
		} catch (Exception exception) {
			throw new NumberFormatException();
		}

	}

	public int getTerm() {
		return term;
	}

	@Override
	public boolean withdraw(double amount) {
		return false;
	}

//	public String writeToString() {
//		StringBuilder toString = new StringBuilder();
//		toString.append(super.writeToString()).append(",");
//		toString.append(term);
//		return toString.toString();
//	}

	public double futureValue() {
		return futureValue(term);
	}

}