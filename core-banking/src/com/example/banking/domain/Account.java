package com.example.banking.domain;

import java.io.Serializable;

// Encapsulation: fields + methods
public class Account extends Object implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private : information hiding principle
	private final String iban; // field/state/attribute
	double balance; // < 0.0 -> illegal state
	protected AccountStatus status = AccountStatus.ACTIVE;
	private static int numberOfAccounts = 0;

	// static method -> static attribute + other static methods
	public static int getNumberOfAccounts() {
		// error : deposit(1);
		return numberOfAccounts;
	}
	
	// default permission -> package private
	

	// constructor -> initialization -> field(s)
	// Alt+Shift+S -> Generate source code
	public Account(final String iban,final  double balance) {
		super(); // No argument constructor / No-arg Constructor
		this.iban = iban;
		this.balance = balance;
		numberOfAccounts++;
	} 

	// getter methods
	
	public String getIban() {
		return iban;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(final AccountStatus status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}
	
	// business methods 
	public void deposit(final double amount) {
		var oldBalance = this.balance;
		getNumberOfAccounts();
		// validation
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount cannot be negative.");
		}
		// business logic
		this.balance = this.balance + amount - 1.0 ;
		assert (oldBalance + amount) == this.balance; // true
		// if it is false then throws AssertionError
		// 1. production -> discards assert  
		// 2. debug -> java -ea -enableassertion
	}
	// Exceptions: 1) Checked Exceptions 2) Unchecked Exceptions
	//                Business Exception    Run-time Exception
	public void withdraw(final double amount) throws InsufficientBalanceException {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount cannot be negative.");
		}
		// business rule
		if (amount > balance) {
			throw new InsufficientBalanceException(
				"Your balance does not cover your expenses", amount-balance
				);
		}
		// business logic
		this.balance = this.balance - amount;
	}
	// override toString()
	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
}
