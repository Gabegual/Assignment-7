package com.example.Assignment_7_Fianl.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment_7_Fianl.*;
import com.example.Assignment_7_Fianl.exceptions.*;
import com.example.Assignment_7_Fianl.models.*;

@RestController
public class CentralController {

	Logger logger = LoggerFactory.getLogger(CentralController.class);

	@RequestMapping("/") // This is an "annotation".
	@ResponseBody
	public String Welcome() {
		return ("Welcome to Merit Bank !");
	}

	@GetMapping("/user")
	public String user() {
		return ("Welcome User UwU");
	}

	@GetMapping("/admin")
	public String admin() {
		return ("Welcome Admin Sir OwO");
	}

	@PostMapping(value = "/admin/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public AccountHolder createAccountHolder(@RequestBody @Valid AccountHolder newAccountHolder) {
		MeritBank.addAccountHolder(newAccountHolder);
		return newAccountHolder;
	}

	@GetMapping(value = "/user/AccountHolders")
	public List<AccountHolder> getAccountHolders() {
		return MeritBank.getAccountHolders();
	}

	@GetMapping(value = "/user/AccountHolders/{id}")
	public AccountHolder getAccountHolder(@PathVariable("id") long id) throws NotFoundException {
		AccountHolder account = MeritBank.getAccountHolder(id);

		if (account == null) {
			logger.error("No account exists");
			throw new NotFoundException("No account exists");
		}

		return account;
	}

	@PostMapping(value = "/admin/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addChecking(@PathVariable("id") long id, @RequestBody CheckingAccount checking)
			throws NotFoundException, ExceedsCombinedBalanceLimitException, NegativeAmountException {
		AccountHolder account = this.getAccountHolder(id);

		if (checking.getBalance() < 0) {
			logger.warn("Negative amount exception");
			throw new NegativeAmountException();
		}

		account.addCheckingAccount(checking);

		return checking;
	}

	@GetMapping(value = "/user/AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getChecking(@PathVariable("id") long id) throws NotFoundException {
		AccountHolder account = this.getAccountHolder(id);
		return account.getCheckingAccounts();
	}

	@PostMapping(value = "/admin/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSaving(@PathVariable("id") long id, @RequestBody SavingsAccount savings)
			throws NotFoundException, ExceedsCombinedBalanceLimitException, NegativeAmountException {

		AccountHolder account = this.getAccountHolder(id);

		if (savings.getBalance() < 0) {
			logger.warn("Negative amount exception");
			throw new NegativeAmountException();
		}

		account.addSavingsAccount(savings);

		return savings;
	}

	@GetMapping(value = "/user/AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavings(@PathVariable("id") long id) throws NotFoundException {
		AccountHolder account = this.getAccountHolder(id);
		return account.getSavingsAccounts();
	}

	@PostMapping(value = "/admin/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@PathVariable("id") long id, @RequestBody CDAccount CDAccount)
			throws NotFoundException, ExceedsCombinedBalanceLimitException, NegativeAmountException,
			ExceedsFraudSuspicionLimitException, MissingFieldException {
		AccountHolder account = this.getAccountHolder(id);

		if (CDAccount.getBalance() < 0) {
			logger.warn("Negative amount exception");
			throw new NegativeAmountException();
		}

		// need explaining on CDAccount.getInterestRate() >=1
		if (CDAccount.getInterestRate() <= 0 || CDAccount.getTerm() <= 0 || CDAccount.getInterestRate() >= 1) {
			logger.warn("Missing interest rate or term");
			throw new MissingFieldException("Missing interest rate or term");
		}

		account.addCDAccount(CDAccount);

		return CDAccount;
	}

	@GetMapping(value = "/user/AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccounts(@PathVariable("id") long id) throws NotFoundException {
		AccountHolder account = this.getAccountHolder(id);

		return account.getCDAccounts();
	}

	@PostMapping("/admin/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering createCDOffering(@RequestBody CDOffering offering) throws MissingFieldException {

		// need more question on || offering.getInterestRate() >= 1)
		if (offering.getInterestRate() <= 0 || offering.getTerm() <= 0 || offering.getInterestRate() >= 1) {
			logger.warn("Missing interest rate or term");
			throw new MissingFieldException("Missing interest rate or term");
		}

		MeritBank.addCDOffering(offering);
		return offering;
	}

	@GetMapping("/user/CDOfferings")
	public List<CDOffering> getCDOfferings() throws NotFoundException {
		List<CDOffering> cdOfferings = MeritBank.getCDOfferings();
		return cdOfferings;
	}

}