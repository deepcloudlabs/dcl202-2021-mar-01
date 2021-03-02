package com.example.banking.domain;

// CheckingAccount: Subclass,   Derived class
// Account        : Superclass, Base Class
public class CheckingAccount extends Account {
	private final double overdraftAmount; // information hiding

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance); // Account(iban,balance)
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	// overloading vs. overriding
	// overloading: methods with the same name and different signature
	//                      in the same class
	// overriding : methods with same name and same signature 
	                      //in inherited classes 
	
	// public, protected, private, (default)
	
	@Override
	public boolean withdraw(double amount) {
		System.out.println("CheckingAccount::withdraw");		
		// validation
		if (amount <= 0.) return false;
		// business rule
		if (amount > (balance + overdraftAmount))
			return false;
		balance = balance - amount;
		return true;
	}

	
}
