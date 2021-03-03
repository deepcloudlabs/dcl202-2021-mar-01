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
	public void withdraw(double amount) throws InsufficientBalanceException {
		System.out.println("CheckingAccount::withdraw");		
		// validation
		if (amount <= 0.) 
			throw new IllegalArgumentException("Amount cannot be negative.");
		// business rule
		if (amount > (balance + overdraftAmount))
			throw new InsufficientBalanceException(
					"Your balance does not cover your expenses", 
					amount-balance-overdraftAmount
					);			
		balance = balance - amount;
	}

	
}
