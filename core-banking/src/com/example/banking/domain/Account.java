package com.example.banking.domain;

// Encapsulation: fields + methods
public class Account extends Object {
	// private : information hiding principle
	private String iban; // field/state/attribute
	double balance; // < 0.0 -> illegal state
	// default permission -> package private
	
	// constructor -> initialization -> field(s)
	// Alt+Shift+S -> Generate source code
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	} 

	// getter methods
	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}
	
	// business methods
	public boolean deposit(double amount) {
		// validation
		if (amount <= 0) {
			return false;
		}
		// business logic
		this.balance = this.balance + amount ;
		return true;
	}
	
	public boolean withdraw(double amount) {
		// validation
		if (amount <= 0) {
			return false;
		}
		// business rule
		if (amount > balance) {
			return false;
		}
		// business logic
		this.balance = this.balance - amount;
		return true;
	}
	// override toString()
	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
}
