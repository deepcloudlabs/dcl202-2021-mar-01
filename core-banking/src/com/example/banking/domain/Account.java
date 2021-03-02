package com.example.banking.domain;

// Encapsulation: fields + methods
public class Account extends Object {
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
	public boolean deposit(final double amount) {
		getNumberOfAccounts();
		// validation
		if (amount <= 0) {
			return false;
		}
		// business logic
		this.balance = this.balance + amount ;
		return true;
	}
	
	public boolean withdraw(final double amount) {
		System.out.println("Account::withdraw");
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
